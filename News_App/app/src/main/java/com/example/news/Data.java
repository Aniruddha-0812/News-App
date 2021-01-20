package com.example.news;

public class Data {

    private String mTitle , mDescription , mImageurl , mUrl;


    public Data(){

    }
    public Data(String title , String Description , String Imageurl ,String Url){

        mTitle = title;
        mDescription = Description;
        mImageurl = Imageurl;
        mUrl = Url;
    }


    public String getmTitle(){
        return mTitle;
    }

    public  String getmDescription(){
        return mDescription;
    }

    public String getmImageurl(){
        return mImageurl;
    }

    public void setmTitle(String title){
        mTitle = title;
    }

    public  void setmDescription(String Description){
        mDescription = Description;
    }

    public void setmImageurl(String url){
        mImageurl = url;
    }


    public String getmUrl(){
        return mUrl;
    }

    public void setmUrl(String url){
        mUrl = url;
    }

}
