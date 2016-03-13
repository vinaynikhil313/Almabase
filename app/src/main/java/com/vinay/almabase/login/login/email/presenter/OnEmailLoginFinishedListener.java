package com.vinay.almabase.login.login.email.presenter;


import com.vinay.almabase.utils.User;

/**
 * Created by Vinay Nikhil Pabba on 21-01-2016.
 */
public interface OnEmailLoginFinishedListener {

    void onSuccess(User user);

    void onEmailError();

    void onPasswordError();

}
