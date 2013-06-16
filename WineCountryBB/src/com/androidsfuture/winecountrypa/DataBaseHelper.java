package com.androidsfuture.winecountrypa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
	
    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.androidsfuture.winecountrypa/databases/";
    private static String DB_NAME = "winecountryPA01";
    private static int DB_VERSION = 1;
    
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
    
    public final String TABLE_NAME_PAIRING = "pairing";
    public static final String KEY_ROWID_PAIRING = "_id";   
    public static final String KEY_WINE = "wine";
    public static final String KEY_SEAFOOD ="seafood";
    public static final String KEY_MEATS = "meats";
    public static final String KEY_SAUCES = "sauces";
    public static final String KEY_CHEESE = "cheese";
    public static final String KEY_VEGGIES = "veggies";
    
    private static String[] FROM = {KEY_ROWID_REGIONS, KEY_NAME, KEY_ADDRESS, KEY_REGION};
    private static String[] FROM_PAIRING ={KEY_ROWID_PAIRING, KEY_WINE, KEY_SEAFOOD,
    	KEY_MEATS, KEY_SAUCES, KEY_CHEESE, KEY_VEGGIES};
    
    private SQLiteDatabase myDataBase; 
    private final Context myContext;

    public DataBaseHelper(Context context) {
    	 
    	super(context, DB_NAME, null, DB_VERSION);
        this.myContext = context;
            
    }	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void createDataBase() throws IOException{
		 
    	boolean dbExist = checkDataBase();
 
    	if(dbExist){
    		//do nothing - database already exist
    	}else{
 
    		//By calling this method and empty database will be created into the default system path
               //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
 
        	try {
 
    			copyDataBase();
 
    		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
    	}
 
    }
	
    private boolean checkDataBase(){
    	 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    	}catch(SQLiteException e){
 
    		//database does't exist yet.
 
    	}
 
    	if(checkDB != null){
 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true : false;
    }
    
    private void copyDataBase() throws IOException{
    	 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
    
    public void openDataBase() throws SQLException{
    	 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
 
	}

public Cursor listAll(){
		
		return myDataBase.query(TABLE_NAME_REGIONS, FROM, null, null, KEY_NAME, null, KEY_NAME);
		//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
		
	}     
    
public Cursor listPhilaRegion(){
		
		return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%phila%' ", null, KEY_NAME, null, KEY_NAME);
		//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
		
	} 
public Cursor listPittsRegion(){
	
	return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%pitts%' ", null, KEY_NAME, null, KEY_NAME);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor listBerksRegion(){
	
	return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%berks%' ", null, KEY_NAME, null, KEY_NAME);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor listLowerRegion(){
	
	return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%lower%' ", null, KEY_NAME, null, KEY_NAME);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor listUpperRegion(){
	
	return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%upper%' ", null, KEY_NAME, null, KEY_NAME);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor listErieRegion(){
	
	return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%erie%' ", null, KEY_NAME, null, KEY_NAME);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor listGroundhogRegion(){
	
	return myDataBase.query(TABLE_NAME_REGIONS, FROM, KEY_REGION + " like '%groundhog%' ", null, KEY_NAME, null, KEY_NAME);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

//Wine queries
public Cursor pairingAmarone(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%amarone%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingBarbera(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%barbera%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingBarolo(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%barolo%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingBeaujolais(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%beaujolais%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingBordeaux(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%bordeaux%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 
public Cursor pairingBrunello(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%brunello%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	}

public Cursor pairingCabernet(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%cabernet%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingChablis(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%chablis%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingChampagne(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%champagne%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingChardonnay(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%chardonnay%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingChateauneuf(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%chateauneuf%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 	

public Cursor pairingChianti(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%chianti%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 


public Cursor pairingGewurz(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%gewurz%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingGrenache(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%grenache%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingMerlot(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%merlot%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingNebbiolo(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%nebbiolo%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingGrigio(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%grigio%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingNoir(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%noir%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingPort(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%port%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingRiesling(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%riesling%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingRioja(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%rioja%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingSangi(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%sangi%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingShiraz(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%shiraz%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingVal(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%val%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

public Cursor pairingZin(){
	
	return myDataBase.query(TABLE_NAME_PAIRING, FROM_PAIRING, KEY_WINE + " like '%zin%' ", null, null, null, null);
	//return myDataBase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
	
	} 

}
