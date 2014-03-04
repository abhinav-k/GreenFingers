package com.example.greenfingers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	 
    // Database Name
    private static final String DATABASE_NAME = "GardenName0";
 
    // Contacts table name
    private static final String TABLE_GARDEN_NAMES = "GardenNames";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PLANT = "plant";
    private static final String KEY_TYPE = "type";
    
    
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GardenName_TABLE = "CREATE TABLE " + TABLE_GARDEN_NAMES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT, "+KEY_TYPE + " TEXT, "+KEY_PLANT + " TEXT "+")";
        db.execSQL(CREATE_GardenName_TABLE);
        System.out.println(CREATE_GardenName_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GARDEN_NAMES);
        System.out.println("In update");
        // Create tables again
        onCreate(db);
}
    public void addGarden(GardenName gardenName) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, gardenName.getName());
        values.put(KEY_TYPE, gardenName.getType());
        values.put(KEY_PLANT, gardenName.getPlant());
        // Inserting Row
        db.insert(TABLE_GARDEN_NAMES, null, values);
        db.close(); // Closing database connection
    }
    public void deldb() {
        SQLiteDatabase db = this.getWritableDatabase();
     db.execSQL("DROP DATABASE GardenName");
        db.close(); // Closing database connection
    }
    
    public GardenName getGardenNames(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.query(TABLE_GARDEN_NAMES, new String[] { KEY_ID,
                KEY_NAME,KEY_TYPE,KEY_PLANT}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        GardenName gardenName = new GardenName(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
       
        return gardenName;
    }
    
    public List<GardenName> getAllGardenNames() {
        List<GardenName> gardenNameList = new ArrayList<GardenName>();
       
        String selectQuery = "SELECT  * FROM " + TABLE_GARDEN_NAMES;
     
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	GardenName gardenName = new GardenName();
            	gardenName.setID(Integer.parseInt(cursor.getString(0)));
            	gardenName.setName(cursor.getString(1));

            	gardenName.setType(cursor.getString(2));
            	gardenName.setPlant(cursor.getString(3));
       
            	gardenNameList.add(gardenName);
            } while (cursor.moveToNext());
        }
     
       
        return gardenNameList;
    }
    public List<GardenName> getAllGardenNamesByName(String text) {
        List<GardenName> gardenNameList = new ArrayList<GardenName>();
       
        String selectQuery = "SELECT  * FROM " + TABLE_GARDEN_NAMES+" Where name = '"+text+"'";
     
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	GardenName gardenName = new GardenName();
            	gardenName.setID(Integer.parseInt(cursor.getString(0)));
            	gardenName.setName(cursor.getString(1));

            	gardenName.setType(cursor.getString(2));
            	gardenName.setPlant(cursor.getString(3));
       
            	gardenNameList.add(gardenName);
            } while (cursor.moveToNext());
        }
     
       
        return gardenNameList;
    }
    
    public int getGardenNameCount() {
        String countQuery = "SELECT  * FROM " + TABLE_GARDEN_NAMES;
        System.out.println(""+countQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int i=cursor.getCount();
        cursor.close();
 
        // return count
        return i;
    }
    public int updateGardenName(GardenName gardenName) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, gardenName.getName());
     
        // updating row
        return db.update(TABLE_GARDEN_NAMES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(gardenName.getID()) });
    }
    public void deleteGardenName(GardenName gardenName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GARDEN_NAMES, KEY_ID + " = ?",
                new String[] { String.valueOf(gardenName.getID()) });
        db.close();
    }
}