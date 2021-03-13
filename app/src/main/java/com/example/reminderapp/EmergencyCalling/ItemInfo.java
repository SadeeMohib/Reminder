package com.example.reminderapp.EmergencyCalling;

public class ItemInfo {
    //this class holds the item infos of recycler
    public String name,num;
    public int imgRec;
    public ItemInfo()
    {

    }
    public ItemInfo(String name,String num,int Img)
    {
        this.name=name;
        this.num=num;
        imgRec=Img;
    }

    public String getName()
    {
        return name;
    }

    public String getNum()
    {
        return num;
    }

    public int getImgRec()
    {
        return imgRec;
    }
}
