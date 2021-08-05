package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int seconds=0;
    private boolean Running=false;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        runTime();
    }

    public void Start(View view) {
        Running=true;
    }

    public void Stop(View view) {
        Running=false;
    }

    public void Restart(View view) {
        Running=false;
        seconds=0;
    }
    private void runTime(){
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour=seconds/3600;
                int min=(seconds%3600)/60;
                int sec=seconds%60;

                String time=String.format("%02d:%02d:%02d",hour,min,sec);
                textView.setText(time);
                if (Running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });


    }
}