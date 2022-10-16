package com.example.portfolio_intent;

import android.os.Parcel;
import android.os.Parcelable;

public class PortFolio implements Parcelable {
    public String name;
    public String position;
    public Course course;

    public String getGithubUsername() {
        return GithubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        GithubUsername = githubUsername;
    }

    public String GithubUsername;
    public PortFolio(String githubUsername) {
        GithubUsername = githubUsername;
    }
    protected PortFolio(Parcel in) {
        name = in.readString();
        position = in.readString();
        course = in.readParcelable(Course.class.getClassLoader());
        education = in.readParcelable(Education.class.getClassLoader());
    }

    public static final Creator<PortFolio> CREATOR = new Creator<PortFolio>() {
        @Override
        public PortFolio createFromParcel(Parcel in) {
            return new PortFolio(in);
        }

        @Override
        public PortFolio[] newArray(int size) {
            return new PortFolio[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Education education;

    public PortFolio(String name, String position, Course course, Education education, String s) {
        this.name = name;
        this.position = position;
        this.course = course;
        this.education = education;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(position);
        dest.writeParcelable(course, flags);
        dest.writeParcelable(education, flags);
    }
}
