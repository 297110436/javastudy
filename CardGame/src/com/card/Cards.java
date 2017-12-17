package com.card;


import java.util.*;

public class Cards {
    private Integer number;//卡牌数值
    private String id; //卡牌点数
    private String name;//卡牌花色

    public Integer getNumber() {
        return number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  Cards(Integer number, String id, String name){
      this.id=id;
      this.name=name;
      this.number=number;
}





}
