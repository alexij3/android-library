package com.buzilov.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText emailText, passwordText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.loginEmail);
        passwordText = findViewById(R.id.loginPassword);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void createAccount(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void login(View view) {
        String email = emailText.getText().toString(),
                password = passwordText.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((task) -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Successfully logged in!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Toast.makeText(this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
