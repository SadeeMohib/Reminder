package com.example.reminderapp.EmergencyCalling;

public class ItemInfo {
    //this class holds the item infos of recycler
    public String name,num;
    public int imgRec,calImg;
    public ItemInfo()
    {

    }
    public ItemInfo(String name,String num,int Img,int calImg)
    {
        this.name=name;
        this.num=num;
        imgRec=Img;
        this.calImg=calImg;

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

    public int getCalImg()
    {
        return  calImg;
    }
}
