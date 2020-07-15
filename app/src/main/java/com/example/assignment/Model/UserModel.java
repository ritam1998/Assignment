package com.example.assignment.Model;

public class UserModel {

    private String userName;
    private String userAge;
    private String userRoll;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserRoll() {
        return userRoll;
    }

    public void setUserRoll(String userRoll) {
        this.userRoll = userRoll;
    }

    public UserModel(String userName, String userAge, String userRoll) {
        this.userName = userName;
        this.userAge = userAge;
        this.userRoll = userRoll;
    }
}
