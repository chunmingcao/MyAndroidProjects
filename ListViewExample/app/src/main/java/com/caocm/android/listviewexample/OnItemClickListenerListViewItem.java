package com.caocm.android.listviewexample;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by caocm_000 on 12/8/2015.
 */
public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context = view.getContext();

        TextView textViewItem = ((TextView) view.findViewById(R.id.textViewItem));

        // get the clicked item name
        String listItemText = textViewItem.getText().toString();

        // get the clicked item ID
        String listItemId = textViewItem.getTag().toString();

        // just toast it
        Toast.makeText(context, "Item: " + listItemText + ", Item ID: " + listItemId, Toast.LENGTH_SHORT).show();

        ((MainActivity) context).alertDialogStores.cancel();
    }
}
