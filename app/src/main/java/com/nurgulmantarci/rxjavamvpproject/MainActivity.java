package com.nurgulmantarci.rxjavamvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nurgulmantarci.rxjavamvpproject.adapters.MoviesAdapter;
import com.nurgulmantarci.rxjavamvpproject.contract.IMovieContract;
import com.nurgulmantarci.rxjavamvpproject.model.Movie;
import com.nurgulmantarci.rxjavamvpproject.presenter.MoviePresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMovieContract.View {

    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private ProgressBar progressBar;

    private MoviePresenter moviePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviePresenter=new MoviePresenter(MainActivity.this);
        moviePresenter.start();
    }

    @Override
    public void init() {
        recyclerView=findViewById(R.id.recyclerview);
        progressBar=findViewById(R.id.progressBar);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        moviePresenter.fetchMovies();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
       if(progressBar!=null && progressBar.isShown()){
           progressBar.setVisibility(View.GONE);
       }
    }

    @Override
    public void showError(String errorMsj) {
        Toast.makeText(this, ""+errorMsj, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadList(List<Movie> movieList) {
        moviesAdapter=new MoviesAdapter(movieList,getApplicationContext());
        recyclerView.setAdapter(moviesAdapter);
    }
}
