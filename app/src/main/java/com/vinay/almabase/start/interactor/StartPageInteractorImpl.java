package com.vinay.almabase.start.interactor;

import android.util.Log;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.vinay.almabase.start.presenter.OnTokenLoginFinishedListener;
import com.vinay.almabase.user.User;
import com.vinay.almabase.utils.Constants;
import com.vinay.almabase.utils.Utilities;

/**
 * Created by Vinay Nikhil Pabba on 30-01-2016.
 */
public class StartPageInteractorImpl implements StartPageInteractor,
        Firebase.AuthResultHandler, ValueEventListener {

    Firebase firebase = new Firebase (Constants.FIREBASE_REF);

    OnTokenLoginFinishedListener listener;

    String provider;

    String TAG = Utilities.getTag(this);

    @Override
    public void loginWithToken (String provider, String accessToken, OnTokenLoginFinishedListener listener) {
        this.listener = listener;
        this.provider = provider;
        if (provider.equals (Constants.PROVIDER_FACEBOOK))
            firebase.authWithOAuthToken (provider, accessToken, this);
        else
            firebase.authWithCustomToken (accessToken, this);
    }

    @Override
    public void onAuthenticated (AuthData authData) {

        firebase.child ("users").child (authData.getUid ()).addListenerForSingleValueEvent (this);
        Log.i (TAG, "AUTHDATA UID = " + authData.getUid ());
        //listener.onLoginSuccessful (provider, authData.getUid (), authData.getToken ());
    }

    @Override
    public void onAuthenticationError (FirebaseError firebaseError) {
        Log.e (TAG, firebaseError.getMessage ());
        listener.onLoginUnsuccessful ();
    }

    @Override
    public void onDataChange (DataSnapshot dataSnapshot) {

        User user = dataSnapshot.getValue (User.class);
        //Log.i (TAG, "DATACHANGE UID = " + user.getUid ());
        //listener.onLoginSuccessful (provider, user);
    }

    @Override
    public void onCancelled (FirebaseError firebaseError) {

    }
}
