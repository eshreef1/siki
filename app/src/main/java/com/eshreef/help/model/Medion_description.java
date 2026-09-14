 package com.eshreef.help.model;

public class Medion_description {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String    description;
    String  Image;
    String menuId;
    String  name;
    String  price;

    public Medion_description(String description, String image, String menuId, String name, String price) {
       this.description = description;
        this.Image = image;
        this.menuId = menuId;
        this.name = name;
        this.price = price;
    }

    public Medion_description() {
    }



    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
