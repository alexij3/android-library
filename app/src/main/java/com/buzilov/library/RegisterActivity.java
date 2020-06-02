package com.buzilov.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText emailText, displayNameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailText = findViewById(R.id.registerEmailText);
        displayNameText = findViewById(R.id.registerDisplayNameText);
        passwordText = findViewById(R.id.registerPasswordText);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void register(View view) {
        String email = emailText.getText().toString(),
                displayName = displayNameText.getText().toString(),
                password = passwordText.getText().toString();

         firebaseAuth.createUserWithEmailAndPassword(email, password)
                 .addOnCompleteListener((resultTask) -> {
                     if (resultTask.isSuccessful()) {
                         Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                     } else {
                        Toast.makeText(this, "Error!" + resultTask.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 });

    }
}
