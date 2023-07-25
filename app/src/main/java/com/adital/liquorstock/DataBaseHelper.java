package com.adital.liquorstock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper to handle my database.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String LIQUOR_TABLE = "LIQUOR_TABLE";
    public static final String COLUMN_LIQUOR_NAME = "LIQUOR_NAME";
    public static final String COLUMN_LIQUOR_TYPE = "LIQUOR_TYPE";
    public static final String COLUMN_MAX_NUMOFBOTTLES = "MAX_NUMOFBOTTLES";
    public static final String COLUMN_CUR_NUMOFBOTTLES = "CUR_NUMOFBOTTLES";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_PERCENT = "PERCENT";
    public static final String DATABASE_NAME = "LiquorStock";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    // This method is called the first time the database is accessed. There should be code to create a new database.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            String createTableStatement = "CREATE TABLE " + LIQUOR_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_LIQUOR_NAME + " TEXT, " + COLUMN_LIQUOR_TYPE + " TEXT, " + COLUMN_MAX_NUMOFBOTTLES + " INT, " + COLUMN_CUR_NUMOFBOTTLES + " INT, " + COLUMN_PERCENT + " INT)";
            sqLiteDatabase.execSQL(createTableStatement);
        } catch (SQLiteException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    // This method is called if the database versiuon  number changes. It prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+LIQUOR_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean addLiquorItem(LiquorModel liquorModel){

       try {
            if (CheckIsDataAlreadyInDBorNot(LIQUOR_TABLE, COLUMN_LIQUOR_NAME, liquorModel.getName())) {
                return false;
            }
        } catch (SQLiteException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        SQLiteDatabase db = this.getWritableDatabase();  // get this database we have created
        ContentValues cv = new ContentValues(); // Associate values, hashmap

        cv.put(COLUMN_LIQUOR_NAME, liquorModel.getName());
        cv.put(COLUMN_LIQUOR_TYPE, liquorModel.getLiquorType());
        cv.put(COLUMN_MAX_NUMOFBOTTLES, liquorModel.getMaxNumOfBottles());
        cv.put(COLUMN_CUR_NUMOFBOTTLES, liquorModel.getCurNumOfBottles());
        cv.put(COLUMN_PERCENT,liquorModel.getPercent());

        long insert = db.insert(LIQUOR_TABLE ,null, cv);

        if(insert == -1){
            db.close();
            return false;
        }else {
            db.close();
            return true;
        }
    }

    public boolean CheckIsDataAlreadyInDBorNot(String TableName, String dbfield, String fieldValue) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "SELECT * FROM " +TableName + " WHERE " + dbfield + " =?";
        Cursor cursor = db.rawQuery(Query, new String[] {fieldValue});
        if(cursor.getCount() <= 0){
            db.close();
            cursor.close();
            return false;
        }
        db.close();
        cursor.close();
        return true;
    }

    public ArrayList<LiquorModel> getLiquorList(String liquorType){
        ArrayList<LiquorModel> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String Query = "SELECT * FROM " + LIQUOR_TABLE + " WHERE " + COLUMN_LIQUOR_TYPE + " =?";
        Cursor cursor = db.rawQuery(Query, new String[] {liquorType});

        if(cursor.moveToFirst()){
            //loop through the results and put them in a list
            do{
                int liquorID = cursor.getInt(0);
                String liquorName = cursor.getString(1);
                String liquorCursorType = cursor.getString(2);
                int mb = cursor.getInt(3);
                int cb = cursor.getInt(4);
                int prct = cursor.getInt(5);

                LiquorModel newLiquor = new LiquorModel(liquorID, liquorName, liquorCursorType, mb, cb, prct);
                returnList.add(newLiquor);

            }while (cursor.moveToNext());
        }else {
            // failure, do not add anything to the list
        }

        // close cursor and databse
        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteLiquor(LiquorModel liquorModel){
        // Find liquorModel in the database, if found delete and return true.
        // if it is not found, return false.

        SQLiteDatabase db = getWritableDatabase();
        String queryString = "DELETE FROM " + LIQUOR_TABLE + " WHERE " + COLUMN_ID + " = " + liquorModel.getId();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            db.close();
            return true;
        }else {
            db.close();
            return false;
        }

    }
}
