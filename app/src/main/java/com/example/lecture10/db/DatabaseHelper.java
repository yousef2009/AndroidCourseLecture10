package com.example.lecture10.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lecture10.model.Student;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, "UniversityDB", null, 1);
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Student.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(Student.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    //==========================================================================================
    public boolean insertStudent(String name, double average) {

        ContentValues cv = new ContentValues();
        cv.put(Student.COL_NAME, name);
        cv.put(Student.COL_AVG, average);

        return db.insert(Student.TABLE_NAME, null, cv) > 0;

    }

    public ArrayList<Student> selectAllStudents() {
        ArrayList<Student> data = new ArrayList<>();

        Cursor c = db.rawQuery(Student.SELECT_TABLE_ALL, null);


        c.moveToFirst();
        while (!c.isAfterLast()) {

            Student s = new Student();

            s.setID(c.getInt(c.getColumnIndex(Student.COL_ID)));
            s.setName(c.getString(c.getColumnIndex(Student.COL_NAME)));
            s.setAverage(c.getDouble(2));
            data.add(s);
            c.moveToNext();
        }

        c.close();
        return data;

    }
}
