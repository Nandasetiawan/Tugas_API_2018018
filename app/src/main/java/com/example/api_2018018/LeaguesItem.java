package com.example.api_2018018;

import com.google.gson.annotations.SerializedName;

public class LeaguesItem {

    @SerializedName("strLeagueAlternate")
    private String strLeagueAlternate;

    @SerializedName("strLeague")
    private String strLeague;

    @SerializedName("strSport")
    private String strSport;

    @SerializedName("idLeague")
    private String idLeague;

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }
}
