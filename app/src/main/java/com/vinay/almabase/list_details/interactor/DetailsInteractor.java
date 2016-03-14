package com.vinay.almabase.list_details.interactor;

import com.vinay.almabase.list_details.presenter.OnDetailsGeneratedListener;

/**
 * Created by Vinay Nikhil Pabba on 14-03-2016.
 */
public interface DetailsInteractor {

	void fetchDetails(int type, OnDetailsGeneratedListener listener);

}
