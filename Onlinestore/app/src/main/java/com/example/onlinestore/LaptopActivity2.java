package com.example.onlinestore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LaptopActivity2 extends AppCompatActivity {

    private ListView listViewLaptops;
    private ArrayList<Laptop> laptops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop2);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        laptops=new ArrayList<>();
        laptops.add(new Laptop(getString(R.string.item_acer_title),getString(R.string.item_acer_info),R.drawable.acer));
        laptops.add(new Laptop(getString(R.string.item_lenovo_title),getString(R.string.item_lenovo_info),R.drawable.lenovo));
        laptops.add(new Laptop(getString(R.string.item_asus_title),getString(R.string.item_asus_info),R.drawable.asus));
        listViewLaptops=findViewById(R.id.listViewLaptops);
        ArrayAdapter<Laptop> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,laptops);
        listViewLaptops.setAdapter(adapter);
        listViewLaptops.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Laptop laptop=laptops.get(position);
                Intent intent=new Intent(getApplicationContext(),LaptopDetailActivity.class);
                intent.putExtra("title",laptop.getTitle());
                intent.putExtra("info",laptop.getInfo());
                intent.putExtra("id",laptop.getId());
                startActivity(intent);
            }
        });

    }
}