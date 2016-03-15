package com.vinay.almabase.start.presenter;

import com.vinay.almabase.user.User;

/**
 * Created by Vinay Nikhil Pabba on 30-01-2016.
 */
public interface OnTokenLoginFinishedListener {

    void onLoginSuccessful(String provider, User user);

    void onLoginUnsuccessful();

}
