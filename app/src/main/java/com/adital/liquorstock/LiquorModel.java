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
    private int maxNumOfBottles;
    private int curNumOfBottles;
    private int percent;

    public LiquorModel(int id, String name, String liquorType, int maxNumOfBottles, int curNumOfBottles, int percent) {
        this.id = id;
        this.name = name;
        this.liquorType = liquorType;
        this.maxNumOfBottles = maxNumOfBottles;
        this.curNumOfBottles = curNumOfBottles;
        this.percent = percent;

    }

    public LiquorModel(String name,String liquorType) {
        this.name = name;
        this.liquorType = liquorType;
        this.id = 0;
        this.maxNumOfBottles = 0;
        this.curNumOfBottles = 0;
        this.percent = 0;
     }

    @Override
    public String toString() {
        return "LiquorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxNumOfBottles=" + maxNumOfBottles +
                ", curNumOfBottles=" + curNumOfBottles +
                ", percent =" + percent +
                '}';
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
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

    public int getMaxNumOfBottles() {
        return maxNumOfBottles;
    }

    public void setMaxNumOfBottles(int maxQuantity) {
        this.maxNumOfBottles = maxQuantity;
    }

    public int getCurNumOfBottles() {
        return curNumOfBottles;
    }

    public void setCurNumOfBottles(int curNumOfBottles) {
        this.curNumOfBottles = curNumOfBottles;
    }
}
