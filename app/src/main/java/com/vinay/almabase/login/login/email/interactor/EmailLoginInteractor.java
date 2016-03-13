package com.vinay.almabase.login.login.email.interactor;


import com.vinay.almabase.login.login.email.presenter.OnEmailLoginFinishedListener;

/**
 * Created by Vinay Nikhil Pabba on 21-01-2016.
 */
public interface EmailLoginInteractor {

    void authenticateWithEmail(String email, String password, OnEmailLoginFinishedListener listener);

}
