package com.example.forster;

public class user {
    private String fullname,id,location,whatyoudo,intrest,record;


    public user() {
    }

    public user(String fullname, String location, String whatyoudo, String intrest, String record, String id) {
        this.fullname = fullname;
        this.location = location;
        this.whatyoudo = whatyoudo;
        this.intrest = intrest;
        this.record = record;
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWhatyoudo() {
        return whatyoudo;
    }

    public void setWhatyoudo(String whatyoudo) {
        this.whatyoudo = whatyoudo;
    }

    public String getIntrest() {
        return intrest;
    }

    public void setIntrest(String intrest) {
        this.intrest = intrest;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
