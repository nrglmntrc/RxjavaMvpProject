package com.nurgulmantarci.rxjavamvpproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nurgulmantarci.rxjavamvpproject.R;
import com.nurgulmantarci.rxjavamvpproject.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    List<Movie> movieList;
    Context context;

    public MoviesAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.movie_item,viewGroup,false);
        MoviesHolder moviesHolder=new MoviesHolder(v);
        return moviesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder moviesHolder, int i) {
        moviesHolder.txtMovie.setText(movieList.get(i).getBaslik());
        Glide.with(context)
                .load(movieList.get(i).getResim())
                .apply(new RequestOptions().centerCrop())
                .into(moviesHolder.imgMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {

        TextView txtMovie;
        ImageView imgMovie;

        public MoviesHolder(@NonNull View itemView) {
            super(itemView);
            txtMovie=itemView.findViewById(R.id.movieTxt);
            imgMovie=itemView.findViewById(R.id.movieIcon);
        }
    }
}
