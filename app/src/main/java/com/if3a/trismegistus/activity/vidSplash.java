package com.if3a.trismegistus.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.if3a.trismegistus.R;

public class vidSplash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vidsplash);

        VideoView simpleVideoView = (VideoView) findViewById(R.id.VV_splash);
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/intro"));

        simpleVideoView.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(vidSplash.this,
                        MainActivity.class));
                finish();
            }
        }, 3150);
    }


}
