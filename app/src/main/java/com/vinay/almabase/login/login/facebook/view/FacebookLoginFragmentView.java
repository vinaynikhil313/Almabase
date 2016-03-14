package com.vinay.almabase.login.login.facebook.view;

import com.vinay.almabase.user.User;

/**
 * Created by Vinay Nikhil Pabba on 22-01-2016.
 */
public interface FacebookLoginFragmentView {

    void openMainPage();

    void onError();

    void writeToSharedPrefernces(User user);

    void showProgressDialog();

    void hideProgressDialog();

}
