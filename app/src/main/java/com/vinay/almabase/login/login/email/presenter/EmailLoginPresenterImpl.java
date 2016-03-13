package com.vinay.almabase.login.login.email.presenter;

import com.vinay.almabase.utils.User;
import com.vinay.almabase.login.login.email.interactor.EmailLoginInteractor;
import com.vinay.almabase.login.login.email.interactor.EmailLoginInteractorImpl;
import com.vinay.almabase.login.login.email.view.EmailLoginFragmentView;
import com.vinay.almabase.login.login.email.view.LoginActivityFragment;


/**
 * Created by Vinay Nikhil Pabba on 21-01-2016.
 */
public class EmailLoginPresenterImpl implements EmailLoginPresenter, OnEmailLoginFinishedListener {

	private EmailLoginFragmentView view;
	private EmailLoginInteractor interactor;

	public EmailLoginPresenterImpl(LoginActivityFragment loginActivityFragment) {
		this.view = loginActivityFragment;
		interactor = new EmailLoginInteractorImpl();
	}

	@Override
	public void authenticateCredentials(String email, String password) {

		view.showProgressDialog();
		interactor.authenticateWithEmail(email, password, this);
	}

	@Override
	public void onEmailError() {
		view.hideProgressDialog();
		view.emailError();
	}

	@Override
	public void onPasswordError() {
		view.hideProgressDialog();
		view.passwordError();
	}

	@Override
	public void onSuccess(User user) {
		view.hideProgressDialog();
		view.openMainPage();
	}
}