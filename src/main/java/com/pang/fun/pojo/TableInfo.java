package com.pang.fun.pojo;

/**
 * 实体关系的定义
 */
public class TableInfo {
    private String type;
    private int price;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public TableInfo(String type, int price) {
        this.type = type;
        this.price = price;
    }
}
