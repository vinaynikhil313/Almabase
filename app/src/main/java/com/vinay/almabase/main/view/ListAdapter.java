package com.vinay.almabase.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vinay.almabase.R;

/**
 * Created by Vinay Nikhil Pabba on 12-03-2016.
 */
public class ListAdapter extends ArrayAdapter<String> {

	private String[] items;

	public ListAdapter(Context context, String[] objects) {
		super(context, 0, objects);
		this.items = objects;
	}

	@Override
	public String getItem(int position) {
		return items[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
		TextView text = (TextView) convertView.findViewById(R.id.list_item_text);
		text.setText(items[position]);
		//text.setTransitionName("title" + position);
		return convertView;
	}

	@Override
	public int getCount() {
		return items.length;
	}
}
