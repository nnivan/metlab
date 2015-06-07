package com.example.iliq.metlab;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Iterator;
import java.util.List;


public class CategorySelectActivity extends Activity {

    Person CONTENT[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        PersonModel pm = PersonModel.getInstance();

        Bundle extras = getIntent().getExtras();
        String msg = extras.getString("message");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_category);


        CONTENT = pm.getList(msg).toArray(new Person[0]);

        ListView listView = (ListView) findViewById(R.id.listView);
        PersonAdapter adapter = new PersonAdapter(this, R.layout.person, CONTENT);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent selectNewActivity = new Intent(CategorySelectActivity.this, PersonDescriptionActivity.class);
                //selectNewActivity.putExtra("image" , "" + CONTENT[position].image);
                selectNewActivity.putExtra("name" , CONTENT[position].name);
                selectNewActivity.putExtra("description" , CONTENT[position].description);
                selectNewActivity.putExtra("phone" , CONTENT[position].phone);
                selectNewActivity.putExtra("email" , CONTENT[position].email);
                startActivity(selectNewActivity);
            }
        });
    }

}
