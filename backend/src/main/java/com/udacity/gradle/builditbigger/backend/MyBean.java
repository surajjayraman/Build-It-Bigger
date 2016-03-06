package com.udacity.gradle.builditbigger.backend;

/**
 * Created by Suraj on 28-02-2016.
 */

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}