package com.example.android.gotinfo.DataPackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class DataContract {
    private DataContract(){}
    public static final String CONTENT_AUTHORITY = "com.example.android.gotinfo";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_TASK = "recents";

    public static final class DataEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TASK);
        public final static String TABLE_NAME = "recents";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME ="name";
        public final static String COLUMN_TITLES = "titles";
        public final static String COLUMN_HOUSE = "house";
        public final static String COLUMN_SPOUSE = "spouse";
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;


        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;
    }
}
