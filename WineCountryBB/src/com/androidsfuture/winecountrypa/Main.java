package com.androidsfuture.winecountrypa;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	private DataBaseHelper myDbHelper;
	
	final Handler mHandler = new Handler();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Typeface vladimirFont = Typeface.createFromAsset(getAssets(), "fonts/VLADIMIR.TTF");
        
        TextView TitleText = (TextView)findViewById(R.id.TxtWineCountry);
    		TitleText.setTypeface(vladimirFont);
    	TextView TitleState = (TextView)findViewById(R.id.TxtState);
    		TitleState.setTypeface(vladimirFont);
    		
    	View regionButton = this.findViewById(R.id.BtnRegion);
    		regionButton.setOnClickListener(this);
    	View mapButton = this.findViewById(R.id.BtnMap);
    		mapButton.setOnClickListener(this);
    	View paringButton = this.findViewById(R.id.BtnPairing);
    		paringButton.setOnClickListener(this);
    		
            myDbHelper = new DataBaseHelper(this);
            
            try {
     
            	myDbHelper.createDataBase();
     
            	} catch (IOException ioe) {
     
            		throw new Error("Unable to create database");
     
            	}
     
            		try {
     
            			myDbHelper.openDataBase();
     
            		}catch(SQLException sqle){
     
            			throw sqle;
     
            		}
     
            myDbHelper.close();
    	
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.BtnRegion:
			startActivity(new Intent(this, RegionList.class));
			break;
			
		case R.id.BtnPairing:
			startActivity(new Intent(this, PairingList.class));
			break;
			
		case R.id.BtnMap:
			//Toast.makeText(this, R.string.use_gps, Toast.LENGTH_LONG).show();
			startActivity(new Intent(this, ListAll.class));
			//Toast.makeText(this, R.string.more_options, Toast.LENGTH_LONG).show();
			break;
		}
	}
	
    //Create menu items
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
		return true;	
    }
    
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    	
    	case R.id.MenuListAll:
    		startActivity(new Intent(this, ListAll.class));
    		return true;
    		
    	case R.id.MenuEvents:
    		startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.localwineevents.com/mobile/off")));
    		return true;
    	
    	case R.id.MenuTasting:
    		startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.pennsylvaniawine.com/TastingTips.aspx")));
    		return true;
    	
    	case R.id.MenuContact:
    		String[] Me = new String[] {"androidboy7@gmail.com"};
    		startActivity(new Intent(android.content.Intent.ACTION_SEND)
				.putExtra(android.content.Intent.EXTRA_EMAIL, Me)
				.addCategory(Intent.CATEGORY_DEFAULT)
				.setType("text/plain"));
    		return true;
    		
    	case R.id.MenuApps:
    		startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://search?q=pub:%22Androids%20Future%22")));
    		return true;
    		
    	case R.id.MenuFriend:
    		startActivity(new Intent(android.content.Intent.ACTION_SEND)
    					.putExtra(android.content.Intent.EXTRA_SUBJECT,"Wine Country - Pennsylvania")
    					.putExtra(android.content.Intent.EXTRA_TEXT, "Here's an app I\'ve been " +
    						"Been using called Wine Country. It has all the wineries in the state " +
    						"as well as a wine pairing guide. Just do a search in Blackberry AppWorld for Wine " +
    						"Country.")
    					.addCategory(Intent.CATEGORY_DEFAULT)
    					.setType("text/plain"));
    		return true;
    	}
    	
		return false;
    
    }

	
}