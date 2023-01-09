package com.if3a.trismegistus.model.servant;

import java.util.ArrayList;

public class ModelServants {

    private String name, face, className, type;
    private int id, atkBase, atkMax, hpBase, hpMax, rarity;
    private Profile profile;
    private ArrayList<Skills> skills = new ArrayList<Skills>();
    private ArrayList<NoblePhantasms> noblePhantasms = new ArrayList<NoblePhantasms>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFace() {
        return face;
    }

    public String getClassName() {
        return className;
    }

    public String getType() {
        return type;
    }

    public int getAtkBase() {
        return atkBase;
    }

    public int getAtkMax() {
        return atkMax;
    }

    public int getHpBase() {
        return hpBase;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getRarity() {
        return rarity;
    }

//===========================================================================================================
    private com.if3a.trismegistus.model.servant.extraAssets extraAssets;

    public extraAssets getextraAssets() {
        return extraAssets;
    }
//===========================================================================================================

    public ArrayList<Skills> getSkills() {
        return skills;
    }

    public ArrayList<NoblePhantasms> getNoblePhantasms() {
        return noblePhantasms;
    }

    public Profile getProfile() {
        return profile;
    }
}


