package com.pucmm.tarea1_temasespeciales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String lastname = intent.getStringExtra("LASTNAME");
        String gender = intent.getStringExtra("GENDER");
        String birthDate = intent.getStringExtra("BIRTHDATE");
        String programming = intent.getStringExtra("PROGRAMMING");

        String fullName = name + " " + lastname;

        TextView nameTextView = findViewById(R.id.nombreTextView);
        TextView genderTextView = findViewById(R.id.genderTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);
        TextView progTextView = findViewById(R.id.progTextView);

        nameTextView.setText(fullName);
        genderTextView.setText(gender);
        dateTextView.setText(birthDate);
        progTextView.setText(programming);

    }
}