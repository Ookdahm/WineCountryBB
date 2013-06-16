package com.androidsfuture.winecountrypa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class PairingList extends Activity implements OnClickListener {
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pairing_list);
        
        View delButton = this.findViewById(R.id.DelButtonPairing);
        	delButton.setOnClickListener(this);

        View wineAmarone = this.findViewById(R.id.wine_Amarone);
        	wineAmarone.setOnClickListener(this);
        View wineBarbera = this.findViewById(R.id.wine_Barbera);
        	wineBarbera.setOnClickListener(this);
        View wineBarolo = this.findViewById(R.id.wine_Barolo);
        	wineBarolo.setOnClickListener(this);
        View wineBeaujolais = this.findViewById(R.id.wine_Beaujolais);
        	wineBeaujolais.setOnClickListener(this);
        View wineBordeaux = this.findViewById(R.id.wine_Bordeaux);
        	wineBordeaux.setOnClickListener(this);
        View wineBrunello = this.findViewById(R.id.wine_Brunello);
        	wineBrunello.setOnClickListener(this);
        View wineCabernet = this.findViewById(R.id.wine_Cab_Sauvignon);
        	wineCabernet.setOnClickListener(this);
        View wineChablis = this.findViewById(R.id.wine_Chablis);
        	wineChablis.setOnClickListener(this);
        View wineChampagne = this.findViewById(R.id.wine_Champagne);
        	wineChampagne.setOnClickListener(this);
        View wineChardonnay = this.findViewById(R.id.wine_Chardonnay);
        	wineChardonnay.setOnClickListener(this);
        View wineChateauneuf = this.findViewById(R.id.wine_Chateauneuf);
        	wineChateauneuf.setOnClickListener(this);
        View wineChianti = this.findViewById(R.id.wine_Chianti);
        	wineChianti.setOnClickListener(this);
        View wineGewurz = this.findViewById(R.id.wine_Gewurztraminer);
        	wineGewurz.setOnClickListener(this);
        View wineGrenache = this.findViewById(R.id.wine_Grenache);
        	wineGrenache.setOnClickListener(this);
        View wineMerlot = this.findViewById(R.id.wine_Merlot);
        	wineMerlot.setOnClickListener(this);
        View wineNebbiolo = this.findViewById(R.id.wine_Nebbiolo);
        	wineNebbiolo.setOnClickListener(this);
        View wineGrigio = this.findViewById(R.id.wine_Pinot_Grigio);
        	wineGrigio.setOnClickListener(this);
        View wineNoir = this.findViewById(R.id.wine_Pinot_Noir);
        	wineNoir.setOnClickListener(this);
        View winePort = this.findViewById(R.id.wine_Port);
        	winePort.setOnClickListener(this);
        View wineRiesling = this.findViewById(R.id.wine_Riesling);
        	wineRiesling.setOnClickListener(this);
        View wineRioja = this.findViewById(R.id.wine_Rioja);
        	wineRioja.setOnClickListener(this);
        View wineSangi = this.findViewById(R.id.wine_Sangiovese);
        	wineSangi.setOnClickListener(this);
        View wineShiraz = this.findViewById(R.id.wine_Shiraz);
        	wineShiraz.setOnClickListener(this);
        View wineVal = this.findViewById(R.id.wine_Valpolicella);
        	wineVal.setOnClickListener(this);
        View wineZin = this.findViewById(R.id.wine_Zinfandel);
        	wineZin.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.DelButtonPairing:
			this.finish();
			break;
			
		case R.id.wine_Amarone:
			startActivity (new Intent(this, Wine_Amarone.class));
			this.finish();
			break;
			
		case R.id.wine_Barbera:
			startActivity (new Intent(this, Wine_Barbera.class));	
			this.finish();
			break;
					
		case R.id.wine_Barolo:
			startActivity (new Intent(this, Wine_Barolo.class));	
			this.finish();
			break;
			
		case R.id.wine_Beaujolais:
			startActivity (new Intent(this, Wine_Beaujolais.class));
			this.finish();
			break;
				
		case R.id.wine_Bordeaux:
			startActivity (new Intent(this, Wine_Bordeaux.class));
			this.finish();
			break;
			
		case R.id.wine_Brunello:
			startActivity (new Intent(this, Wine_Brunello.class));
			this.finish();
			break;
			
		case R.id.wine_Cab_Sauvignon:
			startActivity (new Intent(this, Wine_Cabernet.class));
			this.finish();
			break;
			
		case R.id.wine_Chablis:
			startActivity (new Intent(this, Wine_Chablis.class));
			this.finish();
			break;
			
		case R.id.wine_Champagne:
			startActivity (new Intent(this, Wine_Champagne.class));
			this.finish();
			break;
			
		case R.id.wine_Chardonnay:
			startActivity (new Intent(this, Wine_Chardonnay.class));
			this.finish();
			break;
			
		case R.id.wine_Chateauneuf:
			startActivity (new Intent(this, Wine_Chateauneuf.class));
			this.finish();
			break;
			
		case R.id.wine_Chianti:
			startActivity (new Intent(this, Wine_Chianti.class));
			this.finish();
			break;
			
		case R.id.wine_Gewurztraminer:
			startActivity (new Intent(this, Wine_Gewurz.class));
			this.finish();
			break;
			
		case R.id.wine_Grenache:
			startActivity (new Intent(this, Wine_Grenache.class));
			this.finish();
			break;
			
		case R.id.wine_Merlot:
			startActivity (new Intent(this, Wine_Merlot.class));
			this.finish();
			break;
			
		case R.id.wine_Nebbiolo:
			startActivity (new Intent(this, Wine_Nebbiolo.class));
			this.finish();
			break;
			
		case R.id.wine_Pinot_Grigio:
			startActivity (new Intent(this, Wine_Grigio.class));
			this.finish();
			break;
			
		case R.id.wine_Pinot_Noir:
			startActivity (new Intent(this, Wine_Noir.class));
			this.finish();
			break;
			
		case R.id.wine_Port:
			startActivity (new Intent(this, Wine_Port.class));
			this.finish();
			break;
			
		case R.id.wine_Riesling:
			startActivity (new Intent(this, Wine_Riesling.class));
			this.finish();
			break;
			
		case R.id.wine_Rioja:
			startActivity (new Intent(this, Wine_Rioja.class));
			this.finish();
			break;
			
		case R.id.wine_Sangiovese:
			startActivity (new Intent(this, Wine_Sangi.class));
			this.finish();
			break;
			
		case R.id.wine_Shiraz:
			startActivity (new Intent(this, Wine_Shiraz.class));
			this.finish();
			break;
			
		case R.id.wine_Valpolicella:
			startActivity (new Intent(this, Wine_Val.class));
			this.finish();
			break;
			
		case R.id.wine_Zinfandel:
			startActivity (new Intent(this, Wine_Zin.class));
			this.finish();
			break;
			
		}
	}

}
