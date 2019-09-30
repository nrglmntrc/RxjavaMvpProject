package com.nurgulmantarci.rxjavamvpproject.contract;

import com.nurgulmantarci.rxjavamvpproject.model.Movie;

import java.util.List;

public interface IMovieContract {
    interface View{
        void init();
        void showProgress();
        void hideProgress();
        void showError(String errorMsj);
        void loadList(List<Movie> movieList);
    }

    interface Presenter{
        void start();
        void fetchMovies();
    }
}
