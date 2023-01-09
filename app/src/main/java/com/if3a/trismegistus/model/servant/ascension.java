package com.if3a.trismegistus.model.servant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ascension {

    @SerializedName("1")
    @Expose
    private String satu;
    @SerializedName("2")
    @Expose
    private String dua;
    @SerializedName("3")
    @Expose
    private String tiga;
    @SerializedName("4")
    @Expose
    private String empat;

    public String getSatu() {
        return satu;
    }

    public String getDua() {
        return dua;
    }

    public String getTiga() {
        return tiga;
    }

    public String getEmpat() {
        return empat;
    }

}
