package com.card;

import java.util.ArrayList;
import java.util.List;

public class User{
    private Integer id;//玩家ID
    private String name;//玩家姓名
    public List<Cards> userCards;//手牌

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public User(Integer id, String name){
    this.id=id;
    this.name=name;
    this.userCards=new ArrayList<Cards>();
    }
}
