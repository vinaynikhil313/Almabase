package com.vinay.almabase.start.view;

import com.vinay.almabase.user.User;

/**
 * Created by Vinay Nikhil Pabba on 30-01-2016.
 */
public interface StartPageView {

    void writeToSharedPreferences(String provider, User user);

    void showMessage(String message);

    void openMainPage();

    void openLoginPage();

    void disableLoginPage();

}
