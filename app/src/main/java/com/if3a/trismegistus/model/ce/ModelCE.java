package com.if3a.trismegistus.model.ce;

import java.util.ArrayList;

public class ModelCE {

    private String name, face, flag;
    private int collectionNo, id, rarity, hpBase, hpMax, atkBase, atkMax, lvMax;
    private ProfileCe profile;
    private ArrayList<SkillsCe> skills = new ArrayList<SkillsCe>();

    public String getName() {
        return name;
    }

    public String getFace() {
        return face;
    }

    public final int getId() {
        return id;
    }

    public int getRarity() {
        return rarity;
    }

    public int getHpBase() {
        return hpBase;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getAtkBase() {
        return atkBase;
    }

    public int getAtkMax() {
        return atkMax;
    }

    public int getLvMax() {
        return lvMax;
    }

    public ProfileCe getProfile() {
        return profile;
    }

    public ArrayList<SkillsCe> getSkills() {
        return skills;
    }
}

