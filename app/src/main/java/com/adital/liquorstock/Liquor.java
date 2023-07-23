package com.adital.liquorstock;

public class Liquor {

    // name and image id
    private String liquor_name;
    private int img_id;

    // Constructor
    public Liquor(String liquor_name, int img_id) {
        this.liquor_name = liquor_name;
        this.img_id = img_id;
    }


    /*     Getters and Setters     */
    public String getLiquor_name() {
        return liquor_name;
    }

    public void setLiquor_name(String liquor_name) {
        this.liquor_name = liquor_name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
