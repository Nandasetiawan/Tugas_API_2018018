package com.example.api_2018018;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final SoccerAPI apiClient = ApiClient.getClient().create(SoccerAPI.class);
    private final List<LeaguesItem> leaguesItems = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvleague);
        adapter = new Adapter(this, leaguesItems);
        getLeagues(leaguesItems);
        initRv();

    }

    public void getLeagues(final List<LeaguesItem> leagues) {
        Call<LeaguesResponse> leagueResponseCall = apiClient.getAllLeague();
        leagueResponseCall.enqueue(new Callback<LeaguesResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NotNull Call<LeaguesResponse> call, @NotNull Response<LeaguesResponse> response) {
                if (response.isSuccessful()) {
                    LeaguesResponse leaguesResponse = response.body();
                    if (leaguesResponse != null && leaguesResponse.getLeagues() != null) {
                        leagues.addAll(leaguesResponse.getLeagues());
                        Adapter.NotifyDataSetChanged();
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<LeaguesResponse> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getLeague()/Failure");
            }
        });
    }

    public void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}