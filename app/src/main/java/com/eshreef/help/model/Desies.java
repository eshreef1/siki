package com.eshreef.help.model;

public class Desies {

    String name;
    String image;
    String descatpion;
    String qure;
    String peotacted;

    public Desies(String name, String image, String descatpion, String qure, String peotacted) {
        this.name = name;
        this.image = image;
        this.descatpion = descatpion;
        this.qure = qure;
        this.peotacted = peotacted;
    }

    public Desies() {
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

    public String getQure() {
        return qure;
    }

    public void setQure(String qure) {
        this.qure = qure;
    }

    public String getPeotacted() {
        return peotacted;
    }

    public void setPeotacted(String peotacted) {
        this.peotacted = peotacted;
    }
}
