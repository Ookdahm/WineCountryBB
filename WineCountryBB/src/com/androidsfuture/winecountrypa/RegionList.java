package com.androidsfuture.winecountrypa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class RegionList extends Activity implements OnClickListener {
	

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_list);
      

        
        View delButton = this.findViewById(R.id.DelButtonRegion);
        	delButton.setOnClickListener(this);
        View regionPhila = this.findViewById(R.id.RegionPhila);
        	regionPhila.setOnClickListener(this);
        View regionPitts = this.findViewById(R.id.RegionPitts);
        	regionPitts.setOnClickListener(this);
        View regionBerks = this.findViewById(R.id.RegionBerks);
        	regionBerks.setOnClickListener(this);
        View regionGroundhog = this.findViewById(R.id.RegionGroundhog);
        	regionGroundhog.setOnClickListener(this);
        View regionErie = this.findViewById(R.id.RegionErie);
        	regionErie.setOnClickListener(this);
        View regionLehigh = this.findViewById(R.id.RegionLehigh);
        	regionLehigh.setOnClickListener(this);
        View regionLower = this.findViewById(R.id.RegionLower);
        	regionLower.setOnClickListener(this);
        View regionUpper = this.findViewById(R.id.RegionUpper);
        	regionUpper.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.DelButtonRegion:
			this.finish();
			break;
			
		case R.id.RegionPhila:
			startActivity (new Intent(this, RegionSelPhila.class));
			Toast.makeText(this, "Displaying wineries in the \"Philadelphia Countryside\"", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.RegionPitts:
			startActivity(new Intent(this, RegionSelPitts.class));
			Toast.makeText(this, "Displaying wineries in the \"Pittsburgh Countryside\"", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.RegionBerks:
			startActivity (new Intent(this, RegionSelBerks.class));
			Toast.makeText(this, "Displaying wineries in \"Berks & Lehigh\" counties", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.RegionErie:
			startActivity (new Intent(this, RegionSelErie.class));
			Toast.makeText(this, "Displaying wineries in the \"Lake Erie\" region", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.RegionGroundhog:
			startActivity (new Intent(this, RegionSelGroundhog.class));
			Toast.makeText(this, "Displaying wineries in the \"Groundhog Region\"", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.RegionLower:
			startActivity (new Intent(this, RegionSelLower.class));
			Toast.makeText(this, "Displaying wineries in \"Lower Susquehanna\"", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.RegionUpper:
			startActivity (new Intent(this, RegionSelUpper.class));
			Toast.makeText(this, "Displaying wineries in \"Upper Susquehanna\"", Toast.LENGTH_SHORT).show();
			break;
			
		}
	}
	

}
