package com.example.aosmb9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button sending;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sending = (Button) findViewById(R.id.sendbtn);

        sending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "тестовый текст";
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, text);


                startActivity(Intent.createChooser(intent, "информация"));
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);

                if (sharedText != null) {
                    TextView text = findViewById(R.id.inform);
                    text.setText(sharedText);
                }
            }
        }
    }
}