package com.example.clarinetmaster.notitraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PushActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        Bundle bundle = getIntent().getExtras();

        String message = bundle.getString("message");

        TextView textView = (TextView) findViewById(R.id.txt_message);
        textView.setText(message);
    }
}
