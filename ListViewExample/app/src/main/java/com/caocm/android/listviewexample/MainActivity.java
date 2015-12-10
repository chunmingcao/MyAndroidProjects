package com.caocm.android.listviewexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


public class MainActivity extends Activity {
    AlertDialog alertDialogStores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // a button to show the pop up with a list view
        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.buttonShowPopUp:
                        showPopUp();
                        break;
                }
            }
        };

        findViewById(R.id.buttonShowPopUp).setOnClickListener(handler);
    }

    public void showPopUp(){

        // add your items, this can be done programatically
        // your items can be from a database
        int numberOfItems = 1000;
        ObjectItem[] ObjectItemData = new ObjectItem[numberOfItems];

        for(int x=0; x<numberOfItems; x++){
            int sampleId = 90 + x;
            ObjectItemData[x] = new ObjectItem(sampleId, "Store # " + (x+1));
        }

        // our adapter instance
        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_view_row_item, ObjectItemData);

        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = new ListView(this);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());

        // put the ListView in the pop up
        alertDialogStores = new AlertDialog.Builder(MainActivity.this)
                .setView(listViewItems)
                .setTitle("Stores")
                .show();

    }
}
