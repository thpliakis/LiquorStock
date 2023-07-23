package com.adital.liquorstock;

/**
 * Models a liquor that will be saved in the SQLite database.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */
public class LiquorModel {

    private int id;
    private String name;
    private String liquorType;
    private int maxQuantity;
    private int curQuantity;

    public LiquorModel(int id, String name, String liquorType, int maxQuantity, int curQuantity) {
        this.id = id;
        this.name = name;
        this.liquorType = liquorType;
        this.maxQuantity = maxQuantity;
        this.curQuantity = curQuantity;
    }

    public LiquorModel(String name,String liquorType) {
        this.name = name;
        this.liquorType = liquorType;
        this.id = 0;
        this.maxQuantity = 0;
       this.curQuantity = 0;
     }

    @Override
    public String toString() {
        return "LiquorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxQuantity=" + maxQuantity +
                ", curQuantity=" + curQuantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getLiquorType() {
        return liquorType;
    }

    public void setLiquorType(String liquorType) {
        this.liquorType = liquorType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getCurQuantity() {
        return curQuantity;
    }

    public void setCurQuantity(int curQuantity) {
        this.curQuantity = curQuantity;
    }
}
