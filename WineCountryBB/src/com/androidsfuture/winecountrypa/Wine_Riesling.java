package com.androidsfuture.winecountrypa;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Wine_Riesling extends ListActivity implements OnClickListener {
	
	private DataBaseHelper myDbHelper;
	private Cursor mRegionCursor;
	private static String[] FROM_WINE = {DataBaseHelper.KEY_ROWID_PAIRING, DataBaseHelper.KEY_WINE, DataBaseHelper.KEY_MEATS, 
		DataBaseHelper.KEY_SAUCES, DataBaseHelper.KEY_CHEESE, DataBaseHelper.KEY_SEAFOOD, DataBaseHelper.KEY_VEGGIES};
	private static int[] TO_WINE = {R.id.PairingItem_ID, R.id.PairingItem_Wine, R.id.PairingItem_Meat, R.id.PairingItem_Sauces,
		R.id.PairingItem_Cheeses, R.id.PairingItem_Seafood, R.id.PairingItem_Veggies};
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.pairing_sel);
	        
	     
	        myDbHelper = new DataBaseHelper(this);
	        
	        wineQuery();
	    }



	 private Cursor wineQuery() {
	    	myDbHelper.openDataBase();
	    	mRegionCursor = myDbHelper.pairingRiesling();
	        startManagingCursor(mRegionCursor);

	        
	        // Now create a simple cursor adapter and set it to display
	        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.pairing_item, mRegionCursor, FROM_WINE, TO_WINE);
	        setListAdapter(adapter);
	        myDbHelper.close();
			return mRegionCursor;	
	    }

	   //After user selects museum, show details of the establishment
		@Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        this.finish(); 
		}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
