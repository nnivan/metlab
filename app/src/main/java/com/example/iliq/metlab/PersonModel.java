package com.example.iliq.metlab;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliq on 6/7/15.
 */
public class PersonModel {
    private List<Person> list = new ArrayList<Person>();
    private Context context;
    private String fileName;

    private static PersonModel singleton = null;
    public static PersonModel getInstance () {
        return singleton;
    }

    public static PersonModel createInstance (Context context, String fileName) {
        if(singleton == null) {
            singleton = new PersonModel(context, fileName);
        }
        return singleton;
    }

    private PersonModel(Context context,String fileName) {

        this.fileName = fileName;
        this.context = context;
        try {
            try {
                File file = new File(context.getFilesDir(), fileName);
                if(!file.exists()){
                    file.createNewFile();
                    /*StringBuilder builder = new StringBuilder();
                    builder.append("{Gosho}{min}{desc}{0894481402}{ivannikolov007@gmail.com}{"+ R.drawable.android_logo +"}\n");
                    builder.append("{Pesho}{miion}{desc}{0894481402}{ivannikolov007@gmail.com}{"+ R.drawable.android_logo +"}\n");
                    builder.append("{Joro}{miion}{desc}{0894481402}{ivannikolov007@gmail.com}{"+ R.drawable.android_logo +"}\n");
                    builder.append("{Ivan}{minion}{desc}{0894481402}{ivannikolov007@gmail.com}{" + R.drawable.android_logo + "}\n");
                    builder.append("{Iliq}{minion}{desc}{0894481402}{ivannikolov007@gmail.com}{" + R.drawable.android_logo + "}\n");
                    builder.append("{Minion}{minion}{desc}{0894481402}{ivannikolov007@gmail.com}{" + R.drawable.android_logo + "}\n");

                    OutputStreamWriter oswName = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_APPEND));
                    oswName.write(builder.toString());
                    oswName.close();*/

                }
                file.delete();
                StringBuilder builder = new StringBuilder();
                builder.append("{Gosho Politika}{Politics}{desc}{0894481402}{ivannikolov007@gmail.com}{"+ R.drawable.android_logo +"}\n");
                builder.append("{Pesho Menagera}{Comunication}{desc}{0894481402}{ivannikolov007@gmail.com}{"+ R.drawable.android_logo +"}\n");
                builder.append("{Joro Piara}{Comunication}{desc}{0894481402}{ivannikolov007@gmail.com}{"+ R.drawable.android_logo +"}\n");
                builder.append("{Ivan Biznesa}{Buisness}{desc}{0894481402}{ivannikolov007@gmail.com}{" + R.drawable.android_logo + "}\n");
                builder.append("{Iliq Kichev}{Buisness}{desc}{0894481402}{ivannikolov007@gmail.com}{" + R.drawable.android_logo + "}\n");
                builder.append("{Evlogi Parata}{Buisness}{desc}{0894481402}{ivannikolov007@gmail.com}{" + R.drawable.android_logo + "}\n");

                OutputStreamWriter oswName = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_APPEND));
                oswName.write(builder.toString());
                oswName.close();

            } catch (IOException e) {
                Log.e("writeToFile", "File write failed: " + e.toString());
            }

            InputStream inputStream = context.openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ((receiveString = bufferedReader.readLine()) != null) {

                    Log.e("#####", receiveString);
                    list.add(new Person(receiveString));
                }

                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.i("File not found", e.toString());
        } catch (IOException e) {
            Log.i("Can not read file:", e.toString());
        }
    }
    
    /*private void updateFile(){
        StringBuilder builder = new StringBuilder();
        for(Person p:list){
            builder.append(p.toString());
        }

        try {
            File file = new File(context.getFilesDir(), fileName);
            file.delete();
            OutputStreamWriter oswName = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_APPEND));
            oswName.write(builder.toString());
            oswName.close();
        } catch (IOException e) {
            Log.e("writeToFile", "File write failed: " + e.toString());
        }
    }

    public boolean contains(Person Person){
        return list.contains(Person);
    }

    public void editPerson(Person Person, Person newPerson){

        int PersonIndex  = list.indexOf(Person);
        list.set(PersonIndex,newPerson);
        updateFile();

    }

    public  void  removePerson(Person Person){
        list.remove(Person);
        updateFile();
    }

    public void removeAll(){
        list.clear();
        updateFile();
    }*/

    public List<Person> getList() {
        return list;
    }
    public List<Person> getList(String category) {
        List<Person> retlist = new ArrayList<Person>();
        for(Person p: list){
            if(p.category.equals(category)){
                retlist.add(p);
            }
        }
        return retlist;
    }

}
