package com.example.example05;

import java.io.Serializable;

public class Contact implements Serializable {
    String name;
    String style;
    String date;
    String number;
    boolean icon;

    public Contact(String name, String style, String number,String date, boolean icon) {
        this.name = name;
        this.style = style;
        this.date = date;
        this.icon = icon;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public String getDate() {
        return date;
    }
    public String getNumber(){return number;}

    public boolean isIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setNumber(String number){this.number=number;}

    public void setIcon(boolean icon) {
        this.icon = icon;
    }
}
