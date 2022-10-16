package com.example.portfolio_intent;

import android.os.Parcel;
import android.os.Parcelable;

public class Education implements Parcelable {
    public String title;
    public String degree;
    public String e_year;

    protected Education(Parcel in) {
        title = in.readString();
        degree = in.readString();
        e_year = in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getE_year() {
        return e_year;
    }

    public void setE_year(String e_year) {
        this.e_year = e_year;
    }

    public Education(String title, String degree, String e_year) {
        this.title = title;
        this.degree = degree;
        this.e_year = e_year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(degree);
        dest.writeString(e_year);
    }
}
