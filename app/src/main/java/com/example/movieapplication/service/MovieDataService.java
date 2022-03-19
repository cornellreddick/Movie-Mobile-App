package com.example.movieapplication.service;

import com.example.movieapplication.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {


    //URL Base
    //https://api.themoviedb.org/3/
    //
    //URL of the End point
    // movie/popular?api_key=9bf1e3e553b53d2cdf2796a39a162651
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

}
