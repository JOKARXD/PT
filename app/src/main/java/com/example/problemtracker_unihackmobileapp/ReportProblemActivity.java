package com.example.problemtracker_unihackmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReportProblemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_report_problem);

        // Enable edge-to-edge layout adjustments
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the EditText and Button views in the layout
        EditText editTextFullName = findViewById(R.id.editTextFullName);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        EditText editTextProblemType = findViewById(R.id.editTextProblemType);
        EditText editTextProblemDescription = findViewById(R.id.editTextProblemDescription);
        Button buttonSubmitReport = findViewById(R.id.buttonSubmitReport);

        // Set up the submit button click listener
        buttonSubmitReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve input from each field
                String fullName = editTextFullName.getText().toString().trim();
                String phoneNumber = editTextPhoneNumber.getText().toString().trim();
                String problemType = editTextProblemType.getText().toString().trim();
                String problemDescription = editTextProblemDescription.getText().toString().trim();

                // Validate inputs (ensure no fields are empty)
                if (fullName.isEmpty() || phoneNumber.isEmpty() || problemType.isEmpty() || problemDescription.isEmpty()) {
                    Toast.makeText(ReportProblemActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Show the entered data as a summary in a Toast message (or handle it as needed)
                String summary = "Full Name: " + fullName + "\nPhone Number: " + phoneNumber +
                        "\nType of Problem: " + problemType + "\nDescription: " + problemDescription;
                Toast.makeText(ReportProblemActivity.this, summary, Toast.LENGTH_LONG).show();

                // Further actions (e.g., saving data, sending to a server) can be added here
            }
        });
    }
}
