package com.caocm.android.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*
Without the ViewHolder Design Pattern
Okay, let’s dig it out and see how it works without the ViewHolder pattern.
Let’s take a look at our previous getView() method in ArrayAdapterItem.java
The first time it was loaded, convertView is null. We’ll have to inflate our list item layout and find the TextView via findViewById().
The second time it was loaded, convertView is not null, good! We don’t have to inflate it again. But we’ll use findViewById() again.
The following times it was loaded, convertView is definitely not null. But findViewById() is constantly called, it will work but, it slows down the performance especially if you have lots of items and Views in your ListView.
With the ViewHolder Design Pattern
Now let’s see how it works with the ViewHolder pattern.
The first time it was loaded, convertView is null. We’ll have to inflate our list item layout, instantiate the ViewHolder, find the TextView via findViewById() and assign it to the ViewHolder, and set the ViewHolder as tag of convertView.
The second time it was loaded, convertView is not null, good! We don’t have to inflate it again. And here’s the sweet thing, we won’t have to call findViewById() since we can now access the TextView via its ViewHolder.
The following time it was loaded, convertView is definitely not null. The findViewById() is never called again, and that makes our smooth ListView scrolling.
 */

/**
 * Created by caocm_000 on 12/8/2015.
 */
public class ArrayAdapterItem extends ArrayAdapter<ObjectItem> {

    // our ViewHolder.
    // caches our TextView
    static class ViewHolderItem {
        TextView textViewItem;
    }

    Context mContext;
    int layoutResourceId;
    ObjectItem data[] = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, ObjectItem[] data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;
        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);

            // store the holder with the view.
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        // object item based on the position
        ObjectItem objectItem = data[position];

        // get the TextView and then set the text (item name) and tag (item ID) values
        /*
        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(objectItem.itemName);
        textViewItem.setTag(objectItem.itemId);
        */

        // assign values if the object is not null
        if(objectItem != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.textViewItem.setText(objectItem.itemName);
            viewHolder.textViewItem.setTag(objectItem.itemId);
        }

        return convertView;
    }
}
