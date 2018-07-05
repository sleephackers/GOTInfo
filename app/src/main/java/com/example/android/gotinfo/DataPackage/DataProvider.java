package com.example.android.gotinfo.DataPackage;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import android.util.Log;

public class DataProvider extends ContentProvider {

    private static final int NAME = 100;

    private static final int NAME_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    static {
        sUriMatcher.addURI("com.example.android.gotinfo", "recents", NAME);
        sUriMatcher.addURI("com.example.android.gotinfo", "recents/#", NAME_ID);
    }

    public static final String LOG_TAG = DataProvider.class.getSimpleName();
    private DataDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new DataDbHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor = null;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case NAME:
                cursor = database.query(DataContract.DataEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case NAME_ID:
                selection = DataContract.DataEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};

                cursor = database.query(DataContract.DataEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case NAME:
                return insertData(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }


    private Uri insertData(Uri uri, ContentValues values) {
        String name = values.getAsString(DataContract.DataEntry.COLUMN_NAME);
        if (name == null) {
            throw new IllegalArgumentException("data requires a name");
        }
        String house = values.getAsString(DataContract.DataEntry.COLUMN_HOUSE);
        String spouse = values.getAsString(DataContract.DataEntry.COLUMN_SPOUSE);
        String titles = values.getAsString(DataContract.DataEntry.COLUMN_TITLES);

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        long id = database.insert(DataContract.DataEntry.TABLE_NAME, null, values);
        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case NAME:
                return updateData(uri, contentValues, selection, selectionArgs);
            case NAME_ID:
                selection = DataContract.DataEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateData(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);

        }
    }

    private int updateData(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        if (values.containsKey(DataContract.DataEntry.COLUMN_NAME)) {
            String name = values.getAsString(DataContract.DataEntry.COLUMN_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Data requires a name");
            }
        }

        if (values.containsKey(DataContract.DataEntry.COLUMN_TITLES)) {
            String titles = values.getAsString(DataContract.DataEntry.COLUMN_TITLES);
            if (titles == null) {
                throw new IllegalArgumentException("Data requires a name");
            }
        }

        if (values.containsKey(DataContract.DataEntry.COLUMN_SPOUSE)) {
            String titles = values.getAsString(DataContract.DataEntry.COLUMN_SPOUSE);
            if (titles == null) {
                throw new IllegalArgumentException("Data requires a name");
            }
        }

        if (values.containsKey(DataContract.DataEntry.COLUMN_HOUSE)) {
            String titles = values.getAsString(DataContract.DataEntry.COLUMN_HOUSE);
            if (titles == null) {
                throw new IllegalArgumentException("Data requires a name");
            }
        }

        if (values.size() == 0) {
            return 0;
        }

        // Otherwise, get writeable database to update the data
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        int rowsUpdated = database.update(DataContract.DataEntry.TABLE_NAME, values, selection, selectionArgs);

        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        int rowsDeleted;
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        switch (match)
        {
            case NAME:
                // Delete all rows that match the selection and selection args
                rowsDeleted = database.delete(DataContract.DataEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case NAME_ID:
                // Delete a single row given by the ID in the URI
                selection = DataContract.DataEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = database.delete(DataContract.DataEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }

        if (rowsDeleted != 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;

    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case NAME:
                return DataContract.DataEntry.CONTENT_LIST_TYPE;
            case NAME_ID:
                return DataContract.DataEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }
}

