package com.example.movieapplication.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapplication.R;
import com.example.movieapplication.service.MovieDataService;
import com.example.movieapplication.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoveRepo {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MoveRepo(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<Result> call = movieDataService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }

}
