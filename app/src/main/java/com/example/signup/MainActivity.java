package com.example.signup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name;
    EditText mob;
    EditText email;
    EditText location;
    Button datebtn;
    TextView tv;
    String namedetail;
    String mobdetail;
    String emaildetail;
    String locationdetail;
    CheckBox checkBox;
    DatePicker simpleDatePicker;
    EditText date;
    DatePickerDialog datePickerDialog;
    Spinner sp;
    ArrayList arrayList ;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.button3);
        name = findViewById(R.id.editTextTextPersonName3);
        mob = findViewById(R.id.editTextTextPersonName4);
        email = findViewById(R.id.editTextTextPersonName5);
        location = findViewById(R.id.editTextTextPersonName6);
        checkBox = findViewById(R.id.checkBox);
        date = (EditText) findViewById(R.id.date);
        sp =findViewById(R.id.spinner);

        arrayList = new ArrayList();

        arrayList.add("Electronics and Communication");
        arrayList.add("Computer Science");
        arrayList.add("Civil");
        arrayList.add("Instruments Eng");
        arrayList.add("Mtech");

        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);

        sp.setAdapter(arrayAdapter);









    }





    public void nextpage(View view) {

        if(checkBox.isChecked())
        {

            namedetail = name.getText().toString();
            mobdetail = mob.getText().toString();
            emaildetail = email.getText().toString();
            locationdetail = location.getText().toString();

            Intent obj = new Intent(MainActivity.this,MainActivity2.class);

            obj.putExtra("1",namedetail);
            obj.putExtra("2",mobdetail);
            obj.putExtra("3",emaildetail);
            obj.putExtra("4",locationdetail);

            startActivity(obj);

        }
        else
        {
            AlertDialog.Builder n = new AlertDialog.Builder(MainActivity.this);

            n.setTitle("Note!");
            n.setMessage("Please Accept the Agree condition");
            n.setPositiveButton("okay",null);
            n.show();




        }

    }


    public void date(View view) {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();



    }
}