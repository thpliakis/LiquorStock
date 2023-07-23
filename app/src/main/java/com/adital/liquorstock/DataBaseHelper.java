package com.adital.liquorstock;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public static final String COLUMN_MAX_QUANTITY = "MAX_QUANTITY";
    public static final String COLUMN_CUR_QUANTITY = "CUR_QUANTITY";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "liquor.db", null, 1);
    }

    // This method is called the first time the database is accessed. There should be code to create a new database.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + LIQUOR_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_LIQUOR_NAME + " TEXT, " + COLUMN_LIQUOR_TYPE + " TEXT, " + COLUMN_MAX_QUANTITY + " INT, " + COLUMN_CUR_QUANTITY + " INT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    // This method is called if the database versiuon  number changes. It prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addLiquorItem(LiquorModel liquorModel){
        SQLiteDatabase db = this.getWritableDatabase();  // get this database we have created
        ContentValues cv = new ContentValues(); // Associate values, hashmap

        cv.put(COLUMN_LIQUOR_NAME, liquorModel.getName());
        cv.put(COLUMN_LIQUOR_TYPE, liquorModel.getLiquorType());
        cv.put(COLUMN_MAX_QUANTITY, liquorModel.getMaxQuantity());
        cv.put(COLUMN_CUR_QUANTITY, liquorModel.getCurQuantity());

        long insert = db.insert(LIQUOR_TABLE ,null, cv);

        if(insert == -1){
            return false;
        }else {
            return true;
        }
    }
}
