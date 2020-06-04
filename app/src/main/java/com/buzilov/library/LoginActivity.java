package com.buzilov.library;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.buzilov.library.db.service.AuthenticationService;
import com.buzilov.library.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText, passwordText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.loginEmail);
        passwordText = findViewById(R.id.loginPassword);

    }

    public void createAccount(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void login(View view) {
        final String email = emailText.getText().toString(),
                password = passwordText.getText().toString();

        final AuthenticationService authenticationService = new AuthenticationService();
        User user = authenticationService.authenticateUser(email, password);
        if (user != null) {
            SharedPreferences prefs = getSharedPreferences(getString(R.string.prefs_url), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("authenticated", true);
            editor.putString("email", email);
            editor.putString("displayName", user.getDisplayName());
            editor.apply();
            Toast.makeText(this, "Successfully authenticated!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, "Bad credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
