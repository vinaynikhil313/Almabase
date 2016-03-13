package com.vinay.almabase.login.login.email.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vinay.almabase.R;
import com.vinay.almabase.login.login.email.presenter.EmailLoginPresenter;
import com.vinay.almabase.login.login.email.presenter.EmailLoginPresenterImpl;
import com.vinay.almabase.main.view.MainActivity;


/**
 * Created by Vinay Nikhil Pabba on 14-01-2016. Fragment containing the fields on the Login Screen. Check the
 * credentials entered for logging in using the AuthenticateUser Class and logs in the user. Can also open the Register
 * page when clicked on the text
 */
public class LoginActivityFragment extends Fragment implements EmailLoginFragmentView {

	Button loginButton;
	EditText email;
	EditText password;
	ProgressDialog progressDialog;

	private EmailLoginPresenter presenter;

	private static final String TAG = LoginActivityFragment.class.getSimpleName();

	View viewGroup;

	public LoginActivityFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		viewGroup = inflater.inflate(R.layout.login_fragment_main, container, false);

		presenter = new EmailLoginPresenterImpl(this);

		email = (EditText) viewGroup.findViewById(R.id.emailText);
		password = (EditText) viewGroup.findViewById(R.id.passwordText);

		progressDialog = new ProgressDialog(getContext());
		progressDialog.setMessage("Logging you in");
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setIndeterminate(true);

		loginButton = (Button) viewGroup.findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i(TAG, "Login button Clicked");
				presenter.authenticateCredentials(email.getText().toString(), password.getText().toString());
			}
		});
		return viewGroup;

	}

	@Override
	public void emailError() {
		Toast.makeText(getContext(), "Email Error!", Toast.LENGTH_SHORT).show();
		email.setError("Enter a valid email address");
	}

	@Override
	public void passwordError() {
		Toast.makeText(getContext(), "Password Error!", Toast.LENGTH_SHORT).show();
		password.setError("Between 6 and 20 alphanumeric characters");
	}

	@Override
	public void openMainPage() {
		Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
		startActivity(new Intent(getContext(), MainActivity.class));
		getActivity().overridePendingTransition(R.transition.activity_in, R.transition.activity_out);
		getActivity().finish();
	}

	@Override
	public void hideProgressDialog() {
		progressDialog.hide();
	}

	@Override
	public void showProgressDialog() {
		progressDialog.show();
	}
}
