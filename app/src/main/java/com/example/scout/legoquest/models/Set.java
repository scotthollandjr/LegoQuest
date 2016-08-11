package com.example.scout.legoquest.models;

public class Set {
    private String set_id;
    private String descr;
    private int year;
    private int pieces;
    private String theme1;
    private String theme2;
    private String theme3;
    private String url;
    private String img_tn;
    private String img_big;

    public Set(String set_id, String descr, int year, int pieces, String theme1, String theme2, String theme3, String url, String img_tn, String img_big) {
        this.set_id = set_id;
        this.descr = descr;
        this.year = year;
        this.pieces = pieces;
        this.theme1 = theme1;
        this.theme2 = theme2;
        this.theme3 = theme3;
        this.url = url;
        this.img_tn = img_tn;
        this.img_big = img_big;
    }

    public String getSet_id() {
        return set_id;
    }

    public String getDescr() {
        return descr;
    }

    public int getYear() { return year; }

    public int getPieces() { return pieces; }

    public String getTheme1() { return theme1; }

    public String getTheme2() { return theme2; }

    public String getTheme3() { return theme3; }

    public String getUrl() { return url; }

    public String getImg_tn() { return img_tn; }

    public String getImg_big() { return img_big; }
}
