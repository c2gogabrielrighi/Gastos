package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SimpleListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);


        ArrayList<String> words = new ArrayList<>();
        words.add("Mcqueen");
        words.add("Mat");
        words.add("King");
        words.add("Chick");
        words.add("Doc Hudson");
        words.add("Filmore");
        words.add("Ramone");
        ArrayAdapter<String> itensAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);
        ListView list = findViewById(R.id.list);
        list.setAdapter(itensAdapter);
    }
}



