package com.androidsfuture.winecountrypa;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class RegionSelPhila extends ListActivity{
	
	private DataBaseHelper myDbHelper;
	private Cursor mRegionCursor;
	private static final int ACTIVITY_EDIT=0;
	
	private static String[] FROM_REGION = {DataBaseHelper.KEY_ROWID_REGIONS, DataBaseHelper.KEY_NAME, DataBaseHelper.KEY_ADDRESS, 
		DataBaseHelper.KEY_REGION};
	private static int[] TO_REGION = {R.id._id_Region,R.id.ItemName, R.id.ItemAddress};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_sel);
        
        myDbHelper = new DataBaseHelper(this);
        
        try {
        	listRegion();
        	
        }finally{
        	myDbHelper.close();   
       
        }
        
    }
    
	 private Cursor listRegion() {
	    	myDbHelper.openDataBase();
	    	mRegionCursor = myDbHelper.listPhilaRegion();
	        startManagingCursor(mRegionCursor);

	        
	        // Now create a simple cursor adapter and set it to display
	        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.region_list_item, mRegionCursor, FROM_REGION, TO_REGION);
	        setListAdapter(adapter);
	        myDbHelper.close();
			return mRegionCursor;	
	    }
	 
	    //After user selects winery, show details of the establishment
	 	@Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	               
	        this.findViewById(R.id.Grapes).setFocusable(false);
	        
	        Intent i = new Intent(this, Winery_Item.class);
	        i.putExtra(DataBaseHelper.KEY_ROWID_REGIONS, id);
	        startActivityForResult(i, ACTIVITY_EDIT);
	        this.finish();
	    } 

		
}
