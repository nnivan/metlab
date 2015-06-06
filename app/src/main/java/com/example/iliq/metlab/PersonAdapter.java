package com.example.iliq.metlab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iliq on 6/6/15.
 */
public class PersonAdapter extends ArrayAdapter<person> {

    Context context;
    int layoutResourceID;
    person[] data;

    public PersonAdapter(Context context, int layoutResourceID,  person[] resource) {
        super(context,layoutResourceID, resource);
        this.data = resource;
        this.layoutResourceID = layoutResourceID;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TempHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceID, parent, false);

            holder = new TempHolder();

            holder.imgIcon = (ImageView)row.findViewById(R.id.image_photo);
            holder.txtName = (TextView)row.findViewById(R.id.text_name);
            holder.txtDescription = (TextView)row.findViewById(R.id.text_description);

            row.setTag(holder);
        }
        else
        {
            holder = (TempHolder)row.getTag();
        }

        person per = data[position];
        holder.txtName.setText(per.name);
        holder.txtDescription.setText(per.description);
        holder.imgIcon.setImageResource(per.image);

        return row;
    }

    static class TempHolder
    {
        ImageView imgIcon;
        TextView txtName, txtDescription;
    }
}


