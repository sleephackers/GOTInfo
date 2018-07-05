package com.example.android.gotinfo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.gotinfo.DataPackage.DataContract.DataEntry;

public class DataCursorAdapter extends CursorAdapter {

    public DataCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name_of_character);

        int nameColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_NAME);
        String charName = cursor.getString(nameColumnIndex);
        nameTextView.setText(charName);
    }
}
