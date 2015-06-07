package com.example.iliq.metlab;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class PersonDescriptionActivity extends Activity {
    TextView name, email, description, phone;
    ImageView profilePic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_description);

        Bundle extras = getIntent().getExtras();
        String msgName = extras.getString("name");
        String msgDescription = extras.getString("description");
        String msgPhone = extras.getString("phone");
        String msgEmail = extras.getString("email");
        //int msgImage = Integer.parseInt(extras.getString("image"));

        name = (TextView) findViewById(R.id.txtName);
        email = (TextView) findViewById(R.id.txtEmail);
        description = (TextView) findViewById(R.id.txtDescription);
        profilePic = (ImageView) findViewById(R.id.imageView);
        phone = (TextView) findViewById(R.id.txtPhone);

        phone.setText(msgPhone);
        name.setText(msgName);
        email.setText(msgEmail);
        description.setText(msgDescription);
        //profilePic.setImageResource(msgImage);
    }

    public void  sendEmail(View view){
        String number = email.getText().toString();
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:" + number));
        startActivity(phoneIntent);
    }

    public void callPhone(View view){
        String sendToEmail = phone.getText().toString();
        Intent sendEmailIntent = new Intent(Intent.ACTION_SEND);
        sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { sendToEmail });
        sendEmailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(sendEmailIntent, "Choose an Email client"));
    }

}
