package com.buzilov.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.buzilov.library.dto.User;
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

    public void     register(View view) {
        String email = emailText.getText().toString(),
                displayName = displayNameText.getText().toString(),
                password = passwordText.getText().toString();

         firebaseAuth.createUserWithEmailAndPassword(email, password)
                 .addOnCompleteListener((resultTask) -> {
                     if (resultTask.isSuccessful()) {
                         Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show();
                         final User user = new User(email, displayName);
                         database.collection("users")
                                 .document(firebaseAuth.getCurrentUser().getUid())
                                 .set(user)
                                 .addOnSuccessListener((l) -> {
                                     Toast.makeText(this, "User document snapshot added with ID: " + firebaseAuth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
                                     startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                 })
                                 .addOnFailureListener(e -> {
                                     Toast.makeText(this, "Failed to create a document", Toast.LENGTH_SHORT).show();
                                 });
                     } else {
                        Toast.makeText(this, "Error!" + resultTask.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 });

    }
}
