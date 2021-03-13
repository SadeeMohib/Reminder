package com.example.reminderapp.EmergencyCalling;

public class CallerInfo {
    //this class keep the caller data in firebase
    public String name1,num,id;

    public CallerInfo()
    {

    }

    public CallerInfo(String name1,String num,String id)
    {
        this.name1=name1;
        this.num=num;
        this.id=id;
    }
}
