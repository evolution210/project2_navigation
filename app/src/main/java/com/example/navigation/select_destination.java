package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class select_destination extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_destination);

        String[] des = {"1번 출구", "2번 출구", "3번 출구", "4번 출구"};//list values
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, des);//arrayAdapter instance
        ListView listView = (ListView) findViewById(R.id.listView);//listview instance
        listView.setAdapter(adapter);//listview + adapter

        listView.setOnItemClickListener(//Click the des array_event
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));//클릭한 위치의 des values
                        Toast.makeText(select_destination.this, item, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(select_destination.this,load_navigation.class);//목적지 선택 시 길안내 페이지로 이동
                        startActivity(intent);
                    }
                }

        );
    }
}
