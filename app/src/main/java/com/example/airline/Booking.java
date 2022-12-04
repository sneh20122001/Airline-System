package com.example.airline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class Booking extends AppCompatActivity {
    TextView tvDate;
    EditText etDate;
    DatePickerDialog.onDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        getSupportActionBar().setTitle("Booking");

        tvDate=findViewById(tv_date);
        etDate=findViewById(et_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick (View v ) {
                 DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                         , setListener, year, month, day_of_month);
                 datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 datePickerDialog.show();
             }

        };
        setListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateset (DatePicker view,int year,int month ,int dayOfMonth){
                month=month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };

        etDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v ) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {});
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }

        };

    }
}