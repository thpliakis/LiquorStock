package com.adital.liquorstock;

/**
 * Models general liqueurs.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */
public class Liquor {

    // name and image id
    private String liquor_name;
    private int img_id;
    private int id;


    // Constructor
    public Liquor(String liquor_name, int img_id, int id) {
        this.liquor_name = liquor_name;
        this.img_id = img_id;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
