package com.mawed.calculatejulianday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView julianDayTextView;

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        julianDayTextView = findViewById(R.id.JulianDay);
        calculateJulianDay();
    }
    public void calculateJulianDay(){
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //Calculating the julian date

        if (month <= 2) {
            year -= 1;
            month += 12;
        }
        double A = Math.floor(year / 100.0);
        double B = 2 - A + Math.floor(A / 4.0);
        double JD = Math.floor(365.25 * (year + 4716))
                + Math.floor(30.6001 * (month + 1)) + day + B - 1524.5;
        String JulianDayString = Double.toString(JD);

        julianDayTextView.setText(JulianDayString);
    }
}