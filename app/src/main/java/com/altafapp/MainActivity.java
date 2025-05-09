package com.altafapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnSignup, btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // or your main layout XML

        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);

        // Load default fragment (Login)
        loadFragment(new Login());

        btnLogin.setOnClickListener(v -> loadFragment(new Login()));
        btnSignup.setOnClickListener(v -> loadFragment(new Signup()));
        btnForgotPassword.setOnClickListener(v -> loadFragment(new ForgotPassword()));
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
