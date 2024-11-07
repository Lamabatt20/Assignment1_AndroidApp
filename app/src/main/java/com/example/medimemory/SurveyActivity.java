package com.example.medimemory;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivity extends AppCompatActivity {

    private CheckBox usedBeforeCheckbox;
    private Spinner satisfactionSpinner;
    private RadioGroup recommendRadioGroup;
    private Button submitButton;
    private EditText feedbackEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        usedBeforeCheckbox = findViewById(R.id.usedBeforeCheckbox);
        satisfactionSpinner = findViewById(R.id.satisfactionSpinner);
        recommendRadioGroup = findViewById(R.id.recommendRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        feedbackEditText = findViewById(R.id.feedbackEditText);

        String[] satisfactionOptions = {"Very Satisfied", "Satisfied", "Neutral", "Dissatisfied", "Very Dissatisfied"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, satisfactionOptions);
        satisfactionSpinner.setAdapter(adapter);


        recommendRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String recommend = selectedRadioButton.getText().toString();
            if (recommend!=null) {
                feedbackEditText.setVisibility(View.VISIBLE);
            } else {
                feedbackEditText.setVisibility(View.GONE);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        boolean usedBefore = usedBeforeCheckbox.isChecked();
        String satisfactionRating = satisfactionSpinner.getSelectedItem().toString();
        int selectedId = recommendRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String recommend = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Not specified";


        String feedback = feedbackEditText.getVisibility() == View.VISIBLE ? feedbackEditText.getText().toString() : "No feedback provided";

        if ("No".equals(recommend)) {
            Toast.makeText(this, "I not recommend this medicine, " + feedback, Toast.LENGTH_LONG).show();
        }else if ("Yes".equals(recommend)) {
            Toast.makeText(this, "I recommend this medicine, " + feedback, Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Thank you for your responses!", Toast.LENGTH_LONG).show();
        }
    }
}