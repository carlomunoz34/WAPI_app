package com.iteso.wapi.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String userName;
    private String password;
    private boolean isLogged;

    public Student(){
        this.userName = "";
        this.password = "";
        this.isLogged = false;
    }

    public Student(String userName, String password, boolean isLogged) {
        this.userName = userName;
        this.password = password;
        this.isLogged = isLogged;
    }

    protected Student(Parcel in) {
        this.userName = in.readString();
        this.password = in.readString();
        this.isLogged = in.readByte() != 0;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLogged() {
        return isLogged;
    }
    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.password);
        dest.writeByte(this.isLogged ? (byte) 1 : (byte) 0);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
