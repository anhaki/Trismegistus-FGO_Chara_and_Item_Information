package com.if3a.trismegistus.model.servant;

import com.if3a.trismegistus.model.servant.Comments;

import java.util.ArrayList;

public class Profile {

    private ArrayList<Comments> comments = new ArrayList<Comments>();

    public ArrayList<Comments> getComments() {
        return comments;
    }
}
