package com.vinay.almabase.login.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.vinay.almabase.R;
import com.vinay.almabase.login.forgot.view.ForgotPasswordActivity;
import com.vinay.almabase.login.register.view.RegisterActivity;


/**
 * Created by Vinay Nikhil Pabba on 13-01-2016. Main com.example.benjaminlize.loginapp.GlobalLogin.login screen
 */
@TargetApi(21)
public class LoginActivity extends AppCompatActivity {

	TextView registerText;
	TextView forgotPasswordText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity_main);
		setupWindowAnimations();
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Almabase");

		registerText = (TextView) findViewById(R.id.registerText);
		registerText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openRegistrationPage();
			}
		});

		forgotPasswordText = (TextView) findViewById(R.id.forgotPasswordText);
		forgotPasswordText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openForgotPasswordPage();
			}
		});
	}

	private void openForgotPasswordPage() {
		startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
	}

	public void openRegistrationPage() {
		startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
	}

	private void setupWindowAnimations() {
		Slide slide = new Slide();
		slide.setSlideEdge(Gravity.RIGHT);
		slide.setDuration(1000);
		Log.i("Login Activity", "Inside animation setup");
		getWindow().setExitTransition(slide);
	}

}
