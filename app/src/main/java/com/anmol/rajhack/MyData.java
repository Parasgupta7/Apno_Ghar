package com.anmol.rajhack;

/**
 * Created by anmol on 1/12/2018.
 */

public class MyData {


    private int id;
    private String Title,Image;

    public MyData(String Image,String Title,int id) {
        this.Image=Image;
        this.Title = Title;

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
}
