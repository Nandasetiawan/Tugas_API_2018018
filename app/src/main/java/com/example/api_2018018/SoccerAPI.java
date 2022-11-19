package com.example.api_2018018;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerAPI {

    @GET("all_leagues.php")
    Call<LeaguesResponse> getAllLeague();

}
