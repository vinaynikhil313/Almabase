package com.vinay.almabase.login.login.email.interactor;

import android.util.Log;

import com.firebase.client.Firebase;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.vinay.almabase.login.login.email.presenter.OnEmailLoginFinishedListener;
import com.vinay.almabase.utils.Constants;
import com.vinay.almabase.utils.RestApiClient;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Vinay Nikhil Pabba on 21-01-2016.
 */
public class EmailLoginInteractorImpl implements EmailLoginInteractor {

	Firebase firebase = new Firebase(Constants.FIREBASE_REF);

	private final String TAG = EmailLoginInteractorImpl.class.getSimpleName();

	private OnEmailLoginFinishedListener listener;

	@Override
	public void authenticateWithEmail(String email, String password, OnEmailLoginFinishedListener listener) {
		this.listener = listener;
		Log.i(TAG, "Login with email called");
		int result = validate(email, password);
		switch (result){
			case Constants.CREDENTIALS_OK:
				RequestParams mRequestParams = new RequestParams();
				mRequestParams.put("email", email);
				mRequestParams.put("password", password);
				RestApiClient.post("post", mRequestParams, new JsonResponseHandler());
				break;

			case Constants.PASSWORD_ERROR_CODE:
				listener.onPasswordError();
				break;

			case Constants.EMAIL_ERROR_CODE:
				listener.onEmailError();
				break;
		}

	}

	public int validate(String emailText, String passwordText) {

		if (emailText.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
			return Constants.EMAIL_ERROR_CODE;
		}

		if (passwordText.isEmpty() || passwordText.length() < 6) {
			return Constants.PASSWORD_ERROR_CODE;
		}

		return Constants.CREDENTIALS_OK;
	}

	private class JsonResponseHandler extends JsonHttpResponseHandler {
		@Override
		public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
			super.onSuccess(statusCode, headers, response);
			listener.onSuccess(null);
		}

		@Override
		public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
			Log.i(TAG, "Error in Rest API Call");
			listener.onSuccess(null);
		}
	}

}
