package com.example.android.gotinfo.DataPackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DataDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "recents.db";


    private static final int DATABASE_VERSION = 1;


    public DataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_RECENTS_TABLE = "CREATE TABLE " + DataContract.DataEntry.TABLE_NAME + " ("
                + DataContract.DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataContract.DataEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DataContract.DataEntry.COLUMN_HOUSE + " TEXT, "
                + DataContract.DataEntry.COLUMN_SPOUSE + " TEXT, "
                + DataContract.DataEntry.COLUMN_TITLES + " TEXT);";

        db.execSQL(SQL_CREATE_RECENTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
