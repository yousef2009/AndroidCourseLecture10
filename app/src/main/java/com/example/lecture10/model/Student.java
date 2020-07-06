package com.example.lecture10.model;

public class Student {
    private int ID;
    private String name;
    private double average;


    public static final String TABLE_NAME = "Student";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_AVG = "average";

    public static final String CREATE_TABLE = "create table" + " "
            + TABLE_NAME + "(" + COL_ID + " integer primary key autoincrement, "
            + COL_NAME + " text, " + COL_AVG + " float)";

    public static final String DROP_TABLE = "DROP TABLE IF EXIST" + TABLE_NAME;

    public static final String SELECT_TABLE_ALL = "SELECT * FROM " + TABLE_NAME;

    public Student() {

    }

    public Student(int ID, String name, double average) {
        this.ID = ID;
        this.name = name;
        this.average = average;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
