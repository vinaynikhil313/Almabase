package com.vinay.almabase.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Vinay Nikhil Pabba on 16-12-2015.
 */

public class RestApiClient {

	private final static String TAG = "DirectionsApiHelper";

	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, RequestParams requestParams, AsyncHttpResponseHandler responseHandler) {
		//Log.i(TAG, requestParams.toString());
		client.get(getBaseUrl(url), requestParams, responseHandler);
	}

	public static void post(String url, RequestParams requestParams, AsyncHttpResponseHandler responseHandler) {
		//Log.i(TAG, requestParams.toString());
		client.post(getBaseUrl(url), requestParams, responseHandler);
	}

	private static String getBaseUrl(String url) {
		return Constants.SERVER_ADDRESS + url;
	}

}
