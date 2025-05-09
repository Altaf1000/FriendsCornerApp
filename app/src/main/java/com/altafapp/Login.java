package com.altafapp;

import android.os.Bundle;
import android.text.TextUtils;
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

public class Login extends Fragment {

    private TextInputLayout tilUsernameEmail, tilPassword;
    private TextInputEditText etUsernameEmail, etPassword;
    private MaterialButton btnLogin, btnGoToSignup, btnForgotPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login, container, false);

        // Initialize UI elements
        initViews(view);
        // Set up button listeners
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        tilUsernameEmail = view.findViewById(R.id.til_username_email);
        tilPassword = view.findViewById(R.id.til_password);
        etUsernameEmail = view.findViewById(R.id.et_username_email);
        etPassword = view.findViewById(R.id.et_password);
        btnLogin = view.findViewById(R.id.btn_login);
        btnGoToSignup = view.findViewById(R.id.btn_go_to_signup);
        btnForgotPassword = view.findViewById(R.id.btn_forgot_password);
    }

    private void setupClickListeners() {
        btnLogin.setOnClickListener(v -> validateAndLogin());

        btnGoToSignup.setOnClickListener(v -> {
            // Navigate to SignupFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Signup())
                    .addToBackStack(null)
                    .commit();
        });

        btnForgotPassword.setOnClickListener(v -> {
            // Navigate to ForgotPasswordFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ForgotPassword())
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void validateAndLogin() {
        // Reset errors
        tilUsernameEmail.setError(null);
        tilPassword.setError(null);

        String usernameEmail = etUsernameEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        boolean isValid = true;

        // Validate username/email
        if (TextUtils.isEmpty(usernameEmail)) {
            tilUsernameEmail.setError(getString(R.string.empty_field_error));
            isValid = false;
        }

        // Validate password
        if (TextUtils.isEmpty(password)) {
            tilPassword.setError(getString(R.string.empty_field_error));
            isValid = false;
        }

        // If form is valid, perform login
        if (isValid) {
            // Mock authentication - in a real app, this would involve API calls
            // For demo purposes, we'll just show a success message
            Toast.makeText(getContext(), R.string.login_successful, Toast.LENGTH_SHORT).show();

            // In a real app, you would navigate to the main section of your app
            // For this demo, we'll just clear the input fields
            etUsernameEmail.setText("");
            etPassword.setText("");
        }
    }
}