package com.example.iliq.metlab;

import android.app.Activity;

import android.os.Bundle;
import android.widget.ListView;


public class CategorySelectActivity extends Activity {

    person CONTENT[] = new person[]{
            new person("Name", "Description", R.drawable.android_logo),
            new person("Name", "Description", R.drawable.android_logo),
            new person("Name", "Description", R.drawable.android_logo),
            new person("Name", "Description", R.drawable.android_logo),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_category);
        ListView listView = (ListView) findViewById(R.id.listView);
        PersonAdapter adapter = new PersonAdapter(this, R.layout.person, CONTENT);
        listView.setAdapter(adapter);
    }

}
