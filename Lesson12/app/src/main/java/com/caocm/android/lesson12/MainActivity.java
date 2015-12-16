package com.caocm.android.lesson12;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements TitlesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(String key) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("KEY", key);
        startActivity(detailIntent);
    }
}
