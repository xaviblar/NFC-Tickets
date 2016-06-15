package com.example.xavier.nfc_tickets;

import java.util.ArrayList;

/**
 * Created by BCV on 19/09/2015.
 */
public class Driver {

    private String name;
    private String id;
    private String nickname;
    private String password;

    public Driver(String name, String id, String nickname, String password) {
        this.name = name;
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
