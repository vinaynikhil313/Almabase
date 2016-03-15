package com.vinay.almabase.list_details.view;

import java.util.List;

/**
 * Created by Vinay Nikhil Pabba on 14-03-2016.
 */
public interface DetailsView {

	void onListGenerated(List<Object> objects);

	void hideProgressDialog();

}
