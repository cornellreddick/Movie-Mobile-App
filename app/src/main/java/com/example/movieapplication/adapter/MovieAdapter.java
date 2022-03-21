package com.example.movieapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.databinding.MovieListItemLayoutBinding;
import com.example.movieapplication.model.Movie;
import com.example.movieapplication.view.MovieActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemLayoutBinding movieListItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item_layout,
                parent,
                false);

        return new MovieViewHolder(movieListItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        holder.movieListItemLayoutBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    // View HOlder Class
    public class  MovieViewHolder extends RecyclerView.ViewHolder{
        private MovieListItemLayoutBinding movieListItemLayoutBinding;


        public MovieViewHolder(MovieListItemLayoutBinding movieListItemLayoutBinding) {
            super(movieListItemLayoutBinding.getRoot());
            this.movieListItemLayoutBinding = movieListItemLayoutBinding;

            movieListItemLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION){
                        Movie selectedMovie = movieArrayList.get(position);

                        Intent intent = new Intent(context, MovieActivity.class);
                        intent.putExtra("movie", selectedMovie );
                        context.startActivity(intent);
                    }
                }
            });

        }
    }

}
