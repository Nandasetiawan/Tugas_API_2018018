package com.example.api_2018018;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaguesResponse {
    @SerializedName("leagues")
    private List<LeaguesItem> leagues;

    public List<LeaguesItem> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<LeaguesItem> leagues) {
        this.leagues = leagues;
    }
}
