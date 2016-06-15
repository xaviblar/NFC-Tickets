package com.example.xavier.nfc_tickets;

import java.util.ArrayList;

/**
 * Created by BCV on 19/09/2015.
 */
public class DriverList {
    ArrayList<Driver> drivers=new ArrayList<>();



    public boolean add(Driver d){
        if(notRegistered(d)){
            drivers.add(d);
            return true;
        }
        return false;
    }


    public boolean notRegistered(Driver d){
        for(int i=0;i<drivers.size();i++){
            if(d.getNickname().equals(drivers.get(i).getNickname()) ||
                    d.getPassword().equals(drivers.get(i).getPassword())||
                    d.getId().equals(drivers.get(i).getId())){
                return false;
            }
        }
        return true;
    }


    public boolean notRegistered2(String username, String password){
        for(int i=0;i<drivers.size();i++){
            if(username.equals(drivers.get(i).getNickname()) &&
                    password.equals(drivers.get(i).getPassword())){
                return false;
            }
        }
        return true;
    }

}
