package com.example.aosmb9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sending;


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
}