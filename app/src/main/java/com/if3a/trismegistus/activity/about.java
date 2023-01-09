package com.if3a.trismegistus.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.if3a.trismegistus.R;

public class about extends AppCompatActivity {

    private ActionBar judulBar;
    private Button btnHaki, btnWahyu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        btnHaki = findViewById(R.id.btn_haki);
        btnWahyu = findViewById(R.id.btn_wahyu);

        btnHaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/hakiki.hq");

                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.instagram.android");

                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/hakiki.hq")));
                }

            }
        });

        btnWahyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/_wajiman_");

                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.instagram.android");

                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/_wajiman_")));
                }

            }
        });




        judulBar = getSupportActionBar();
        judulBar.hide();


    }
}