package com.tw.androidbootcamp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayDeque;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText("AndroidBootcamp");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View buttonView) {
                textView.setBackgroundColor(Color.BLUE);
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);

        final String[] values = new String[] {"Android", "iPhone", "WindowsMobile"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.list_item, R.id.item, values);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,  View view, int i, long l) {
                Intent intent =  new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("TEST", values[i]);
                Log.d("AAAAAA", values[i]);
                startActivity(intent);

            }
        });

    }



}
