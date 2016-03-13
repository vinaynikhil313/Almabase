package com.vinay.almabase.login.login.email.view;


/**
 * Created by Vinay Nikhil Pabba on 22-01-2016.
 */
public interface EmailLoginFragmentView {

    void emailError();

    void passwordError();

    void openMainPage();

    void showProgressDialog();

    void hideProgressDialog();

}