package com.example.iliq.metlab;

/**
 * Created by iliq on 6/6/15.
 */
public class Person {
    public String name, description, phone, email, category;
    public int image;
    public Person(String name, String description, int imageUrl) {
        this.name = name;
        this.description = description;
        this.image = imageUrl;
    }
    public Person(String name, String category, String description,
                  String email, String phone,
                  int ResourseLayoutImage){
        this.description = description;
        this.email = email;
        this.image = ResourseLayoutImage;
        this.name = name;
        this.phone = phone;
        this.category = category;
    }
    public Person(){super();}

    @Override
    public String toString() {
        String ret = "{" + name +"}" +"{" + category + "}"
                +"{" + description+ "}"+ "{" +email+ "}"+ "{" + phone+ "}"
                +"{" + image + "}" +"/r/n";
        return ret;
    }

    public Person (String s){
        int j = s.indexOf('{');
        int i = s.indexOf('}',j);
        this.name = s.substring(j + 1, i);
        j = s.indexOf('{',i);
        i = s.indexOf('}',j);
        this.category = s.substring(j+1,i);
        j = s.indexOf('{',i);
        i = s.indexOf('}',j);
        this.description = s.substring(j+1,i);
        j = s.indexOf('{',i);
        i = s.indexOf('}',j);
        this.email = s.substring(j+1,i);
        j = s.indexOf('{',i);
        i = s.indexOf('}',j);
        this.phone = s.substring(j+1,i);
        j = s.indexOf('{',i);
        i = s.indexOf('}',j);
        this.image = Integer.parseInt(s.substring(j+1,i));
    }
}
