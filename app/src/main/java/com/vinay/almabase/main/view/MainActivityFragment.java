package com.vinay.almabase.main.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vinay.almabase.list_details.view.DetailsActivity;
import com.vinay.almabase.R;
import com.vinay.almabase.utils.Constants;
import com.vinay.almabase.utils.Utilities;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

	private final String TAG = Utilities.getTag(this);

	private final String[] items = new String[] {"Posts",
			"Comments",
			"Users"};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		ListView mListView = (ListView) view.findViewById(R.id.itemsList);
		ListAdapter adapter = new ListAdapter(getContext(), Constants.ITEMS);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getContext(), DetailsActivity.class);
				intent.putExtra(DetailsActivity.EXTRA_PARAM_ID, position);

				Log.i(TAG, "Clicked position is " + position);
				View viewById = view.findViewById(R.id.list_item_text);
				if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
							new Pair<View, String>(viewById, DetailsActivity.VIEW_NAME_HEADER_TITLE));
					Log.i(TAG, options.toBundle().toString());
					ActivityCompat.startActivity(getActivity(), intent,
							options.toBundle());
				}
				else{
					startActivity(intent);
				}
			}
		});

		return view;
	}
}
