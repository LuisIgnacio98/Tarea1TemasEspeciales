package com.pucmm.tarea1_temasespeciales;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "com.pucmm.tarea1_temasespciales.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText lastNameEditText = (EditText) findViewById(R.id.editTextTextPersonName2);
        Spinner genderSpinner = (Spinner) findViewById(R.id.spinner);
        DatePicker birthDatePicker = (DatePicker) findViewById(R.id.dateOfBirthDatePicker);
        RadioButton siButtom = (RadioButton) findViewById(R.id.siButton);
        RadioButton noButtom = (RadioButton) findViewById(R.id.noButton);
        CheckBox java = (CheckBox) findViewById(R.id.javaBox);
        CheckBox python = (CheckBox) findViewById(R.id.pyBox);
        CheckBox js = (CheckBox) findViewById(R.id.jsBox);
        CheckBox golang = (CheckBox) findViewById(R.id.goBox);
        CheckBox cplus = (CheckBox) findViewById(R.id.cbox);
        CheckBox csharp = (CheckBox) findViewById(R.id.csharpBox);
        Button send = (Button) findViewById(R.id.enviarButton);
        Button clean = (Button) findViewById(R.id.limpiarButton);


        noButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.setEnabled(false);
                python.setEnabled(false);
                js.setEnabled(false);
                golang.setEnabled(false);
                cplus.setEnabled(false);
                csharp.setEnabled(false);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayMessageActivity.class);
                boolean validado = false;

                if(TextUtils.isEmpty(nameEditText.getText().toString().trim())){
                    nameEditText.setError("Tienes que digitar un nombre");
                    validado = true;
                }
                if(TextUtils.isEmpty(lastNameEditText.getText().toString().trim())){
                    lastNameEditText.setError("Tienes que digitar un apellido");
                    validado = true;
                }
                if(genderSpinner.getSelectedItemId() == 0){
                    TextView errorText = (TextView)genderSpinner.getSelectedView();
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);
                    errorText.setText("Seleccione su genero");
                    validado=true;
                }

                if(siButtom.isChecked()){
                    if(!java.isChecked() && !python.isChecked() && !js.isChecked() && !golang.isChecked() && !cplus.isChecked()
                    && !csharp.isChecked()){
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
                        alertDialogBuilder.setTitle("ERROR");
                        alertDialogBuilder.setMessage("Tienes que seleccionar al menos un lenguaje.");
                        alertDialogBuilder.setCancelable(true);
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        validado=true;
                    }
                }


                if(!validado){
                    String name = nameEditText.getText().toString();
                    String lastname = lastNameEditText.getText().toString();
                    String gender = genderSpinner.getSelectedItem().toString();
                    String birthDate = birthDatePicker.getDayOfMonth()+ "/" + (birthDatePicker.getMonth() + 1) + "/" + birthDatePicker.getYear();
                    String likeProgramming = "No me gusta programar.";
                    if(siButtom.isChecked()){
                        likeProgramming = "Me gusta programar. Mis lenguajes favoritos son: ";
                        if(java.isChecked()){
                            likeProgramming+="Java, ";
                        }
                        if(python.isChecked()){
                            likeProgramming+="Python, ";
                        }
                        if(js.isChecked()){
                            likeProgramming+="JS, ";
                        }
                        if(golang.isChecked()){
                            likeProgramming+="GOLANG, ";
                        }
                        if(cplus.isChecked()){
                            likeProgramming+="C/C++, ";
                        }
                        if(csharp.isChecked()){
                            likeProgramming+="C#, ";
                        }
                    }
                    intent.putExtra(EXTRA_MESSAGE, name);
                    intent.putExtra("LASTNAME", lastname);
                    intent.putExtra("GENDER", gender);
                    intent.putExtra("BIRTHDATE", birthDate);
                    intent.putExtra("PROGRAMMING", likeProgramming);
                    startActivity(intent);
                }

            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setText("");
                lastNameEditText.setText("");
                genderSpinner.setSelection(0,true);
                siButtom.setChecked(false);
                noButtom.setChecked(false);
                java.setChecked(false);
                python.setChecked(false);
                js.setChecked(false);
                golang.setChecked(false);
                cplus.setChecked(false);
                csharp.setChecked(false);

                java.setEnabled(true);
                python.setEnabled(true);
                js.setEnabled(true);
                golang.setEnabled(true);
                cplus.setEnabled(true);
                csharp.setEnabled(true);
            }
        });
    }

}