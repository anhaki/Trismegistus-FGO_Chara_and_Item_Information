package com.if3a.trismegistus.model.servant;

import java.util.ArrayList;

public class NoblePhantasms {

    private String name, rank, type, card, detail;
    private ArrayList<String> effectFlags = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getType() {
        return type;
    }

    public String getCard() {
        return card;
    }

    public String getDetail() {
        return detail;
    }

    public ArrayList<String> getEffectFlags() {
        return effectFlags;
    }
}
