package com.example.lecture10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lecture10.adapter.StudentAdapter;
import com.example.lecture10.db.DatabaseHelper;
import com.example.lecture10.model.Student;

import java.util.ArrayList;

public class PrintStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_student);

        final RecyclerView rvStudents = findViewById(R.id.rvStudents);
        DatabaseHelper db = new DatabaseHelper(this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvStudents.setLayoutManager(manager);

        ArrayList<Student> data = db.selectAllStudents();
        StudentAdapter studentAdapter = new StudentAdapter(this, data);
        rvStudents.setAdapter(studentAdapter);

    }
}