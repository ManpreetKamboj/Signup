package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    ListView listView;
    List<String> listItems = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    String s1;
    String s2;
    String s3;
    String s4;
    String phoneNo;
    String message;

    //comments
//sssjjsjj





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);

        s1 = getIntent().getStringExtra("1");
        listItems.add(s1);
        s2 = getIntent().getStringExtra("2");
        listItems.add(s2);
        s3 = getIntent().getStringExtra("3");
        listItems.add(s3);
        s4 = getIntent().getStringExtra("4");
        listItems.add(s4);
        String[] items = {};
        //arrayList.add();
        //arrayList.add(getIntent().getStringArrayExtra("2").);
        //arrayList.add(getIntent().getStringArrayExtra("3"));
        //arrayList.add(getIntent().getStringArrayExtra("4"));
        items = listItems.toArray(new String[listItems.size()]);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 1)
                {
                    phoneNo = listItems.get(position);
                    message = "hiii";

                    ActivityCompat.requestPermissions(MainActivity2.this,
                            new String[]{Manifest.permission.SEND_SMS},
                            1);


                }
                if( position == 3)
                {
                    Intent obj = new Intent(MainActivity2.this,MainActivity3.class);

                    startActivity(obj);



                }



                }






        });




    }




    @Override
    public void onRequestPermissionsResult (int requestCode,String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }



}





