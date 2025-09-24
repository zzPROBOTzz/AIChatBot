package com.example.aichatbot;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OnboardingActivity extends AppCompatActivity {

	private FirebaseAuth firebaseAuth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_onboarding);

		firebaseAuth = FirebaseAuth.getInstance();

		EditText emailInput = findViewById(R.id.input_email);
		EditText passwordInput = findViewById(R.id.input_password);
		Button signUpButton = findViewById(R.id.button_sign_up);
		TextView signInLink = findViewById(R.id.text_sign_in);

		signUpButton.setOnClickListener(v -> {
			String email = emailInput.getText().toString().trim();
			String password = passwordInput.getText().toString();
			if (validate(email, password)) {
				firebaseAuth.createUserWithEmailAndPassword(email, password)
						.addOnCompleteListener(task -> {
							if (task.isSuccessful()) {
								goToDiscover();
							} else {
								Toast.makeText(this, String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
							}
						});
			}
		});

		signInLink.setOnClickListener(v -> {
			String email = emailInput.getText().toString().trim();
			String password = passwordInput.getText().toString();
			if (validate(email, password)) {
				firebaseAuth.signInWithEmailAndPassword(email, password)
						.addOnCompleteListener(task -> {
							if (task.isSuccessful()) {
								goToDiscover();
							} else {
								Toast.makeText(this, String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
							}
						});
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
		if (user != null) {
			goToDiscover();
		}
	}

	private boolean validate(String email, String password) {
		if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
			Toast.makeText(this, "Email and password required", Toast.LENGTH_SHORT).show();
			return false;
		}
		if (password.length() < 6) {
			Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	private void goToDiscover() {
		Intent intent = new Intent(OnboardingActivity.this, DiscoverActivity.class);
		startActivity(intent);
		finish();
	}
}
