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

public class ForgotPassword extends Fragment {

    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private MaterialButton btnResetPassword, btnBackToLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.forgotpassword, container, false);

        // Initialize UI elements
        initViews(view);
        // Set up button listeners
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        tilEmail = view.findViewById(R.id.til_email);
        etEmail = view.findViewById(R.id.et_email);
        btnResetPassword = view.findViewById(R.id.btn_reset_password);
        btnBackToLogin = view.findViewById(R.id.btn_back_to_login);
    }

    private void setupClickListeners() {
        btnResetPassword.setOnClickListener(v -> validateAndResetPassword());

        btnBackToLogin.setOnClickListener(v -> {
            // Navigate back to LoginFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Login())
                    .commit();
        });
    }

    private void validateAndResetPassword() {
        // Reset errors
        tilEmail.setError(null);

        String email = etEmail.getText().toString().trim();
        boolean isValid = true;

        // Validate email
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError(getString(R.string.email_error));
            isValid = false;
        }

        // If email is valid, send reset link
        if (isValid) {
            // Mock password reset - in a real app, this would involve API calls
            Toast.makeText(getContext(), R.string.reset_password_message, Toast.LENGTH_SHORT).show();

            // Clear input field
            etEmail.setText("");
        }
    }
}