package com.vinay.almabase.login.login.facebook.presenter;

import com.vinay.almabase.user.User;

/**
 * Created by Vinay Nikhil Pabba on 27-01-2016.
 */
public interface OnFacebookLoginFinishedListener {

    void onFirebaseLoginSuccess(User user);

    void onFirebaseLoginFailure();

}
