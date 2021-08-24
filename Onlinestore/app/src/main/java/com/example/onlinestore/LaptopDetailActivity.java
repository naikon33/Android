package com.example.onlinestore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LaptopDetailActivity extends AppCompatActivity {
    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_detail);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        textViewTitle=findViewById(R.id.textViewTitle);
        textViewInfo=findViewById(R.id.textViewInfo);
        imageViewId=findViewById(R.id.imageViewId);
        Intent intent=getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("id")){
            String title=intent.getStringExtra("title");
            String info=intent.getStringExtra("info");
            int id=intent.getIntExtra("id",-1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewId.setImageResource(id);
        }else{
            Intent backCategory=new Intent(this,LaptopActivity2.class);
            startActivity(backCategory);
        }

    }
}