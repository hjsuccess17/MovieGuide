package com.esoxjem.movieguide.listing;

import android.util.Log;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.MoviesWraper;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortType;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * @author arun
 */
class MoviesListingInteractorImpl implements MoviesListingInteractor {
    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
        Log.d("DAGGER", "MoviesListingInteractorImpl()");
    }

    @Override
    public Observable<List<Movie>> fetchMovies() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            //ramda
            return tmdbWebService.popularMovies().map(MoviesWraper::getMovieList);
            //java
            /*return tmdbWebService.popularMovies().map(new Function<MoviesWraper, List<Movie>>() {

                @Override
                public List<Movie> apply(MoviesWraper moviesWraper) throws Exception {
                    return moviesWraper.getMovieList();
                }
            });*/
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies().map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(favoritesInteractor.getFavorites());
        }
    }

}
