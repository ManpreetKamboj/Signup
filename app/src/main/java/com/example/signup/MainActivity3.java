package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        webView  = findViewById(R.id.web);
        editText = findViewById(R.id.editTextTextPersonName);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://google.com");
    }

    public void search(View view) {


        webView.loadUrl("https://"+editText.getText().toString());

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        webView.goBack();
    }
}