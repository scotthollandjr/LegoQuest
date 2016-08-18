package com.example.scout.legoquest.models;

import org.parceler.Parcel;

/**
 * Created by scout on 8/17/16.
 */
@Parcel
public class Theme {
    private String descr;

    public Theme() {}

    public Theme(String descr) {
        this.descr = descr;
    }

    public String getDescr() { return descr; }
}
