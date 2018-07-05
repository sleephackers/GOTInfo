package com.example.android.gotinfo;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.android.gotinfo.DataPackage.DataContract;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int DATA_LOADER=0;
    DataCursorAdapter mCursorAdapter;
    int FLAG = 0;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView dataListView = (ListView) findViewById(R.id.list);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.empty_view);
        dataListView.setEmptyView(emptyView);
        mCursorAdapter=new DataCursorAdapter(this,null);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connMgr.getActiveNetworkInfo();
        dataListView.setAdapter(mCursorAdapter);
        getLoaderManager().initLoader(DATA_LOADER,null,this);

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, SearchNameActivity.class);
                intent.putExtra("flag",FLAG);
                Uri currentPetUri = ContentUris.withAppendedId(DataContract.DataEntry.CONTENT_URI, id);
                intent.setData(currentPetUri);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.search_name);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (networkInfo != null && networkInfo.isConnected()) {

                    Intent myIntent = new Intent(MainActivity.this, SearchNameActivity.class);
                myIntent.putExtra("String", query);
                MainActivity.this.startActivity(myIntent);}
                else
                    Toast.makeText(MainActivity.this, "CHECK YOUR NETWORK CONNECTIVITY",
                            Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
    {
        //Define a projection of columns we care abt
        String[] projection={DataContract.DataEntry._ID, DataContract.DataEntry.COLUMN_NAME};

        return new CursorLoader(this, DataContract.DataEntry.CONTENT_URI,projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data)
    {
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader)
    {
        mCursorAdapter.swapCursor(null);

    }

}
