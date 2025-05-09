package com.altafapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends Fragment {

    private TextInputLayout tilEmail, tilUsername, tilPassword, tilConfirmPassword;
    private TextInputEditText etEmail, etUsername, etPassword, etConfirmPassword;
    private MaterialButton btnSignup, btnBackToLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.signup, container, false);

        // Initialize UI elements
        initViews(view);
        // Set up button listeners
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        tilEmail = view.findViewById(R.id.til_email);
        tilUsername = view.findViewById(R.id.til_username);
        tilPassword = view.findViewById(R.id.til_password);
        tilConfirmPassword = view.findViewById(R.id.til_confirm_password);

        etEmail = view.findViewById(R.id.et_email);
        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        etConfirmPassword = view.findViewById(R.id.et_confirm_password);

        btnSignup = view.findViewById(R.id.btn_signup);
        btnBackToLogin = view.findViewById(R.id.btn_back_to_login);
    }

    private void setupClickListeners() {
        btnSignup.setOnClickListener(v -> validateAndSignup());

        btnBackToLogin.setOnClickListener(v -> {
            // Navigate back to LoginFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Login())
                    .commit();
        });
    }

    private void validateAndSignup() {
        // Reset errors
        tilEmail.setError(null);
        tilUsername.setError(null);
        tilPassword.setError(null);
        tilConfirmPassword.setError(null);

        String email = etEmail.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        boolean isValid = true;

        // Validate email
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError(getString(R.string.email_error));
            isValid = false;
        }

        // Validate username (minimum 3 characters)
        if (TextUtils.isEmpty(username) || username.length() < 3) {
            tilUsername.setError(getString(R.string.username_error));
            isValid = false;
        }

        // Validate password (minimum 6 characters)
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            tilPassword.setError(getString(R.string.password_error));
            isValid = false;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            tilConfirmPassword.setError(getString(R.string.passwords_not_match));
            isValid = false;
        }

        // If form is valid, perform signup
        if (isValid) {
            // Mock registration - in a real app, this would involve API calls
            Toast.makeText(getContext(), R.string.signup_successful, Toast.LENGTH_SHORT).show();

            // Navigate to login fragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Login())
                    .commit();
        }
    }
}