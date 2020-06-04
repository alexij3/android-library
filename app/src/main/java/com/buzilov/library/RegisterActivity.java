package com.buzilov.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.buzilov.library.db.repository.UserRepository;
import com.buzilov.library.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore database;
    private EditText emailText, displayNameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();

        emailText = findViewById(R.id.registerEmailText);
        displayNameText = findViewById(R.id.registerDisplayNameText);
        passwordText = findViewById(R.id.registerPasswordText);

    }

    public void register(View view) {
        String email = emailText.getText().toString(),
                displayName = displayNameText.getText().toString(),
                password = passwordText.getText().toString();

        User user = new User();
        user.setDisplayName(displayName);
        user.setEmail(email);
        user.setPassword(password);

        UserRepository userRepository = new UserRepository();

        Long createdUserId = userRepository.create(user);

        if (createdUserId != null) {
            Toast.makeText(this, "Successfully registered! Now you can log in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            Toast.makeText(this, "Something went wrong during registration! Try again", Toast.LENGTH_SHORT).show();
        }

    }
}
