package com.example.reminderapp.DoctorsList;

public class DocListInfo {
        String name,num,desc,mail;
        int proflImg,phnImg,mailImg;

        public DocListInfo(String name,String num,String desc,String mail,int proflImg,int phnImg,int mailImg)
        {
            this.name=name;
            this.num=num;
            this.desc=desc;
            this.mail=mail;
            this.proflImg=proflImg;
            this.phnImg=phnImg;
            this.mailImg=mailImg;
        }

        public String getName() {
            return name;
        }

        public String getNum() {
            return num;
        }

        public String getDesc() {
            return desc;
        }

        public String getMail() {
            return mail;
        }

        public int getProflImg() {
            return proflImg;
        }

        public int getPhnImg() {
            return phnImg;
        }

        public int getMailImg() {
            return mailImg;
        }
}
