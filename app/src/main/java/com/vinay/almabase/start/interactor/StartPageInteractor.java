package com.vinay.almabase.start.interactor;

import com.vinay.almabase.start.presenter.OnTokenLoginFinishedListener;

/**
 * Created by Vinay Nikhil Pabba on 30-01-2016.
 */
public interface StartPageInteractor {

    void loginWithToken(String provider, String accessToken, OnTokenLoginFinishedListener listener);

}
