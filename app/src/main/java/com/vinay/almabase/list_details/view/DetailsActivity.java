/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vinay.almabase.list_details.view;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.TextView;

import com.vinay.almabase.R;
import com.vinay.almabase.list_details.presenter.DetailsPresenter;
import com.vinay.almabase.list_details.presenter.DetailsPresenterImpl;
import com.vinay.almabase.utils.Constants;
import com.vinay.almabase.utils.Utilities;

import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsView {

	private final String TAG = Utilities.getTag(this);

	// Extra name for the ID parameter
	public static final String EXTRA_PARAM_ID = "detail:_id";

	// View name of the header title. Used for activity scene transitions
	public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

	private TextView mTitle;
	private ListView mListView;

	private DetailsPresenter presenter;
	private ProgressDialog mProgressDialog;

	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		if (Build.VERSION.SDK_INT >= 21) {
			getWindow().requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS);
			Slide ts_enter = new Slide();
			Transition ts_exit = new Explode();
			ts_enter.setSlideEdge(Gravity.RIGHT);
			ts_enter.setDuration(1000);
			ts_exit.setDuration(1000);

			getWindow().setEnterTransition(ts_enter);
			getWindow().setExitTransition(ts_exit);
		}

		presenter = new DetailsPresenterImpl(this);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_details);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Details");

		position = getIntent().getIntExtra(EXTRA_PARAM_ID, 0);

		mTitle = (TextView) findViewById(R.id.item_title);

		mListView = (ListView) findViewById(R.id.itemDetails);

		ViewCompat.setTransitionName(mTitle, VIEW_NAME_HEADER_TITLE);

		mTitle.setText(Constants.ITEMS[position].toUpperCase());

		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setMessage("Please wait...");
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mProgressDialog.setIndeterminate (true);
		mProgressDialog.show();

		presenter.getDetails(position);

	}

	@Override
	public void onListGenerated(List<Object> objects) {
		DetailsListAdapter adapter = new DetailsListAdapter(this, objects);
		mListView.setAdapter(adapter);
	}

	@Override
	public void hideProgressDialog() {
		mProgressDialog.hide();
	}
}
