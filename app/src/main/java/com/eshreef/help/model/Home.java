package com.eshreef.help.model;

public class Home {
    String name;
    String image;
    String descatpion;

    public Home(String name, String image, String descatpion) {
        this.name = name;
        this.image = image;
        this.descatpion = descatpion;
    }

    public Home() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescatpion() {
        return descatpion;
    }

    public void setDescatpion(String descatpion) {
        this.descatpion = descatpion;
    }
}
