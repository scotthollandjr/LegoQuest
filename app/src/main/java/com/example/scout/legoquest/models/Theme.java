package com.example.scout.legoquest.models;

import org.parceler.Parcel;

/**
 * Created by scout on 8/17/16.
 */
@Parcel
public class Theme {
    private String theme_id;
    private String descr;

    public Theme() {}

    public Theme(String theme_id, String descr) {
        this.theme_id = theme_id;
        this.descr = descr;
    }

    public String getTheme_id() { return theme_id; }

    public String getDescr() { return descr; }
}
