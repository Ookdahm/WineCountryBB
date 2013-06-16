package com.androidsfuture.winecountrypa;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Wine_Events extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        Intent webSite = new Intent(Intent.ACTION_VIEW);
		webSite.setData(Uri.parse("http://localwineevents.com"));
		startActivity(webSite); 
    
		this.finish();
    }

}
