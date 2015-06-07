package com.example.iliq.metlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    GridView gridView;


    static final String[] GRID_ELEMENTS = new String[]{
            "Politics", "Comunication", "Buisness"};

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonModel pm = PersonModel.createInstance(this, "Personsfile.txt");
        gridView = (GridView) findViewById(R.id.gridView1);

        gridView.setAdapter(new ImageAdapter(getApplicationContext(), GRID_ELEMENTS));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
               /* Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.grid_item_label))
                                .getText(), Toast.LENGTH_SHORT).show();
                */
                Intent intent = new Intent(MainActivity.this, CategorySelectActivity.class);
                intent.putExtra("message", GRID_ELEMENTS[position]);
                Toast.makeText(MainActivity.this, "Selecting", Toast.LENGTH_SHORT);
                startActivity(intent);


            }
        });

    }
}

