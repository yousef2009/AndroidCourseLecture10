package com.example.lecture10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lecture10.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnAddStudent = findViewById(R.id.btnAddStudent);
        final Button btnPrintStudents = findViewById(R.id.btnPrintStudents);

        final EditText etName = findViewById(R.id.etName);
        final EditText etAverage = findViewById(R.id.etAverage);


        final DatabaseHelper db = new DatabaseHelper(this);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean n = db.insertStudent(etName.getText().toString(),
                        Double.parseDouble(etAverage.getText().toString())  );

                if(n){
                    Toast.makeText(MainActivity.this, "Insert Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Insert is failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btnPrintStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PrintStudent.class);
                startActivity(i);
            }
        });





    }
}