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
    private int maxQuantity;
    private int curQuantity;

    public LiquorModel(int id, String name, int maxQuantity, int curQuantity) {
        this.id = id;
        this.name = name;
        this.maxQuantity = maxQuantity;
        this.curQuantity = curQuantity;
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
