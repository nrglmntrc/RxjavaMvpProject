package com.nurgulmantarci.rxjavamvpproject.presenter;

import com.nurgulmantarci.rxjavamvpproject.Constants;
import com.nurgulmantarci.rxjavamvpproject.contract.IMovieContract;
import com.nurgulmantarci.rxjavamvpproject.model.Movie;
import com.nurgulmantarci.rxjavamvpproject.services.IMovieService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviePresenter implements IMovieContract.Presenter {
    public MoviePresenter(IMovieContract.View view){
        mView=view;
    }

    IMovieContract.View mView;


    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void fetchMovies() {

        IMovieService iMovieService=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(IMovieService.class);

        iMovieService.getMovieList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                            mView.showProgress();
                    }

                    @Override
                    public void onNext(List<Movie> movieList) {
                            mView.hideProgress();
                            mView.loadList(movieList);
                    }

                    @Override
                    public void onError(Throwable e) {
                            mView.showError(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
