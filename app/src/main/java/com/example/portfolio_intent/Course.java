package com.example.portfolio_intent;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
    public String organization;
    public String C_name;
    public String c_year;

    protected Course(Parcel in) {
        organization = in.readString();
        C_name = in.readString();
        c_year = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public String getC_year() {
        return c_year;
    }

    public void setC_year(String c_year) {
        this.c_year = c_year;
    }

    public Course(String organization, String c_name, String c_year) {
        this.organization = organization;
        C_name = c_name;
        this.c_year = c_year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(organization);
        dest.writeString(C_name);
        dest.writeString(c_year);
    }
}
