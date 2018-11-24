package com.iteso.wapi.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Homework implements Parcelable {

    private Integer idHomework;
    private Integer fk_subject;
    private String descriptionHomework;
    private Integer deliveryDate;
    private Integer deliveryTime;


    public Homework(Integer idHomework, Integer fk_subject, String descriptionHomework, Integer deliveryDate, Integer deliveryTime) {
        this.idHomework = idHomework;
        this.fk_subject = fk_subject;
        this.descriptionHomework = descriptionHomework;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    public Homework() {
    }

    @Override
    public String toString() {
        return "Homework{" +
                "idHomework=" + idHomework +
                ", fk_subject=" + fk_subject +
                ", descriptionHomework='" + descriptionHomework + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }

    public Integer getIdHomework() {
        return idHomework;
    }

    public void setIdHomework(Integer idHomework) {
        this.idHomework = idHomework;
    }

    public Integer getFk_subject() {
        return fk_subject;
    }

    public void setFk_subject(Integer fk_subject) {
        this.fk_subject = fk_subject;
    }

    public String getDescriptionHomework() {
        return descriptionHomework;
    }

    public void setDescriptionHomework(String descriptionHomework) {
        this.descriptionHomework = descriptionHomework;
    }

    public Integer getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Integer deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idHomework);
        dest.writeValue(this.fk_subject);
        dest.writeString(this.descriptionHomework);
        dest.writeValue(this.deliveryDate);
        dest.writeValue(this.deliveryTime);
    }

    protected Homework(Parcel in) {
        this.idHomework = (Integer) in.readValue(Integer.class.getClassLoader());
        this.fk_subject = (Integer) in.readValue(Integer.class.getClassLoader());
        this.descriptionHomework = in.readString();
        this.deliveryDate = (Integer) in.readValue(Integer.class.getClassLoader());
        this.deliveryTime = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Homework> CREATOR = new Creator<Homework>() {
        @Override
        public Homework createFromParcel(Parcel source) {
            return new Homework(source);
        }

        @Override
        public Homework[] newArray(int size) {
            return new Homework[size];
        }
    };
}
