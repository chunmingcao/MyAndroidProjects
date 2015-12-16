package com.caocm.android.lesson12;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String key = getIntent().getExtras().getString("KEY");

        /*DetailFragment details = new DetailFragment();
        details.setArguments(getIntent().getExtras());*/
        Log.i("DetailActicity", "start");
        TextView content = (TextView)findViewById(R.id.content);
        content.setText(ListData.dic.get(key));
/*
        FragmentManager fragmentManager = getFragmentManager();
        DetailFragment detailFragment = (DetailFragment)fragmentManager.findFragmentById(R.id.details);
        detailFragment.updateContent(key);*/
        /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.details2, details);
        fragmentTransaction.commit();*/

    }/*
    @Override
    public void onResume(){
        super.onResume();
        Log.i("DetailActicity", "onResume");
        TextView content = (TextView)findViewById(R.id.content);
        content.setText("XXXXXXXXXXXXX");
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
