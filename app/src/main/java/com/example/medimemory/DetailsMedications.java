package com.example.medimemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsMedications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_medications);
        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("medication_id");

        Medication medication= Medication.medication[id];


        TextView txtdesc= (TextView)findViewById(R.id.medicationd);
        TextView txtfrequency= (TextView)findViewById(R.id.ftext);
        TextView txtname= (TextView)findViewById(R.id.medicationname);
        TextView txttime= (TextView)findViewById(R.id.timeofday);


        txtname.setText(medication.getName());
        txtdesc.setText(medication.getDescription());
        txtfrequency.setText(medication.getFrequency());
        txttime.setText(medication.getTimeOfDay());

        ImageView image = (ImageView)findViewById(R.id.medication);
        image.setImageResource(medication.getImageResourceId());

        Switch medicationSwitch = findViewById(R.id.medication_switch);
        medicationSwitch.setChecked(medication.isTaken());
        medicationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> medication.setTaken(isChecked));


        Button addButton = findViewById(R.id.addm);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsMedications.this, SurveyActivity.class);
                startActivity(intent);
            }
        });

    }
}