package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.MoviesWraper;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortType;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.TmdbWebService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by lykhappy on 2018-03-31.
 */

public class TestMoviesListingInteractorImpl implements MoviesListingInteractor {

    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;

    public TestMoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor, TmdbWebService tmdbWebService, SortingOptionStore sortingOptionStore) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        this.sortingOptionStore = sortingOptionStore;
    }

    @Override
    public Observable<List<Movie>> fetchMovies() {
        List<Movie> datas = new ArrayList<>();
        Movie movie = new Movie();
        movie.setId("269149");
        movie.setBackdropPath("/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg");
        movie.setOverview("Test Overview");
        movie.setReleaseDate("2018-02-07");
        movie.setTitle("Test Title");
        movie.setPosterPath("/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg");
        datas.add(movie);
        return Observable.just(datas);
    }
}
