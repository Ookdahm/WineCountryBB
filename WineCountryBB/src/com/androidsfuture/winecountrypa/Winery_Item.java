package com.androidsfuture.winecountrypa;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Winery_Item extends Activity implements OnClickListener{
	
    public final String TABLE_NAME_REGIONS = "regions";
    public static final String KEY_ROWID_REGIONS = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_ZIP = "zip";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_WEBSITE = "website";
    public static final String KEY_HOURS = "hours";
    public static final String KEY_REGION = "region";
    
	private SQLiteDatabase mDb;
	private DataBaseHelper mDbHelper;
	private Long mRowId;
	
	private TextView itemName;
	private TextView itemAddress;
	private TextView itemPhone;
	private TextView itemEmail;
	private TextView itemHours;
	private TextView itemWebsite;
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_result);
        
        mDbHelper = new DataBaseHelper(this);
        mDb = mDbHelper.getWritableDatabase();
        
        //Get fields to be updated
        itemName = (TextView)findViewById(R.id.ResultName);
        itemAddress = (TextView)findViewById(R.id.Result_Address);
        itemPhone = (TextView)findViewById(R.id.Result_Phone);
        itemEmail = (TextView)findViewById(R.id.Result_Email);
        itemHours = (TextView)findViewById(R.id.Result_Hours);
        itemWebsite = (TextView)findViewById(R.id.Result_Website);
        	
        //Create clickable links
        itemAddress.setOnClickListener(this);
        itemPhone.setOnClickListener(this);
        itemEmail.setOnClickListener(this);
        itemWebsite.setOnClickListener(this);
        
        /*webViewLink = (TextView)findViewById(R.id.ListItem_WebViewLink);
        	webViewLink.setOnClickListener(this); */
        
       
        
        mRowId = savedInstanceState != null ? savedInstanceState.getLong(DataBaseHelper.KEY_ROWID_REGIONS) 
				: null;
        
		if (mRowId == null) {
			Bundle extras = getIntent().getExtras();            
			mRowId = extras != null ? extras.getLong(DataBaseHelper.KEY_ROWID_REGIONS) 
									: null;
		}
		
		populateFields();
		
    }
    
    
    private void populateFields() {
        if (mRowId != null) {
            Cursor note = fetchItems(mRowId);
            startManagingCursor(note);
            itemName.setText(note.getString(
                    note.getColumnIndexOrThrow(DataBaseHelper.KEY_NAME)));
            itemAddress.setText(note.getString(
                    note.getColumnIndexOrThrow(DataBaseHelper.KEY_ADDRESS)));
            itemPhone.setText(note.getString(
                    note.getColumnIndexOrThrow(DataBaseHelper.KEY_PHONE)));
            itemEmail.setText(note.getString(
                    note.getColumnIndexOrThrow(DataBaseHelper.KEY_EMAIL)));
            itemHours.setText(note.getString(
                    note.getColumnIndexOrThrow(DataBaseHelper.KEY_HOURS)));
            itemWebsite.setText(note.getString(
            		note.getColumnIndexOrThrow(DataBaseHelper.KEY_WEBSITE)));
        }
    }
    
    public Cursor fetchItems(long rowId) throws SQLException {

        Cursor mCursor =

                mDb.query(true, TABLE_NAME_REGIONS, new String[] {KEY_ROWID_REGIONS,
                		KEY_NAME, KEY_ADDRESS, KEY_EMAIL, KEY_WEBSITE, 
                		KEY_PHONE, KEY_HOURS}, KEY_ROWID_REGIONS + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(DataBaseHelper.KEY_ROWID_REGIONS, mRowId);
    }
 
    
    @Override
    protected void onResume() {
        super.onResume();
        populateFields();
    }
    
       


	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.Result_Address:
			startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?daddr=" + itemAddress.getText().toString())));
			break;
				
		case R.id.Result_Phone:
			startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + itemPhone.getText().toString())));
			break;
			
		case R.id.Result_Email:
			String[] Me = new String[] {itemEmail.getText().toString()};
			Intent sendTo = new Intent(android.content.Intent.ACTION_SEND);
				sendTo.putExtra(android.content.Intent.EXTRA_EMAIL, Me);
				sendTo.setType("text/plain");
				startActivity(Intent.createChooser(sendTo, null));
		    break;
		    
		case R.id.Result_Website:
			Intent webSite = new Intent(Intent.ACTION_VIEW);
			webSite.setData(Uri.parse(itemWebsite.getText().toString()));
			startActivity(webSite);
			break;

		}
		
		
	}
}
