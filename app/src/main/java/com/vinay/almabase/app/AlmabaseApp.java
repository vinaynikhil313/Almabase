package com.vinay.almabase.app;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.firebase.client.Firebase;

/**
 * Created by Vinay Nikhil Pabba on 11-03-2016.
 */
public class AlmabaseApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Firebase.setAndroidContext(this);
		Firebase.getDefaultConfig().setPersistenceEnabled(true);
		FacebookSdk.sdkInitialize(getApplicationContext());
	}
}
