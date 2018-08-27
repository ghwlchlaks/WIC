package com.spider.choi.wic;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ListViewItem implements Parcelable,Serializable{
    private Drawable iconDrawable;
    private String titleStr;
    private String heartCount;
    private String likeCount;

    public ListViewItem(){
    }
    public ListViewItem(Drawable drawable, String title, String count1, String count2) {
        iconDrawable = drawable;
        titleStr = title;
        heartCount = count1;
        likeCount = count2;
    }

    protected ListViewItem(Parcel in) {
        titleStr = in.readString();
        heartCount = in.readString();
        likeCount = in.readString();
    }

    public static final Creator<ListViewItem> CREATOR = new Creator<ListViewItem>() {
        @Override
        public ListViewItem createFromParcel(Parcel in) {
            return new ListViewItem(in);
        }

        @Override
        public ListViewItem[] newArray(int size) {
            return new ListViewItem[size];
        }
    };

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setTitle(String title) {
        titleStr = title;
    }
    public void setHeartCount(String count){
        heartCount = count;
    }
    public void setLikeCount(String count) {
        likeCount = count;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }
    public String getTitleStr() {
        return this.titleStr;
    }
    public String getLikeCount() {
        return this.likeCount;
    }
    public String getHeartCount() {
        return this.heartCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleStr);
        dest.writeString(heartCount);
        dest.writeString(likeCount);
    }
}
