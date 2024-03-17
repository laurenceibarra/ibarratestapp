package com.example.ibarratestapp;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nameField = findViewById(R.id.nameEditText);
        EditText emailField = findViewById(R.id.emailEditText);
        EditText phoneField = findViewById(R.id.phoneEditText);
        EditText aboutField = findViewById(R.id.aboutEditText);

        TextView emptyNameTextView = findViewById(R.id.emptyNameTextView);
        TextView emptyEmailTextView = findViewById(R.id.emptyEmailTextView);
        TextView emptyPhoneTextView = findViewById(R.id.emptyPhoneTextView);
        TextView emptyAboutTextView = findViewById(R.id.emptyAboutTextView);

        Button submitButton = findViewById(R.id.saveButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTextValue = nameField.getText().toString();
                String emailTextValue = emailField.getText().toString();
                String phoneTextValue = phoneField.getText().toString();
                String aboutTextValue = aboutField.getText().toString();

                if(nameTextValue.isEmpty() && emailTextValue.isEmpty() && phoneTextValue.isEmpty() && aboutTextValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields!", Toast.LENGTH_LONG).show();
                }
                else {
                    emptyNameTextView.setText("Hello " + nameTextValue + "!");
                    emptyEmailTextView.setText("Your email is: " + emailTextValue);
                    emptyPhoneTextView.setText("Your phone is: " + phoneTextValue);
                    emptyAboutTextView.setText(aboutTextValue);
                }
            }
        });
    }
}