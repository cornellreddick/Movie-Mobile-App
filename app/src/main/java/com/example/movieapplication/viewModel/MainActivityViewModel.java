package com.example.movieapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapplication.model.MoveRepo;
import com.example.movieapplication.model.Movie;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MoveRepo moveRepo;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        moveRepo = new MoveRepo(application);

    }

    //Live Data
    public LiveData<List<Movie>> getAllMovies(){
        return moveRepo.getMutableLiveData();
    }
}
