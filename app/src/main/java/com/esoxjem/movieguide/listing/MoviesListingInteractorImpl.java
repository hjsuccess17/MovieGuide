package com.esoxjem.movieguide.listing;

import android.util.Log;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.MoviesWraper;
import com.esoxjem.movieguide.Tv;
import com.esoxjem.movieguide.TvWraper;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortType;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.TmdbTvWebService;
import com.esoxjem.movieguide.network.TmdbWebService;

import java.util.ArrayList;
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
    private TmdbTvWebService tmdbTvWebService;

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
        Log.d("DAGGER", "MoviesListingInteractorImpl()");
    }

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, TmdbTvWebService tmdbTvWebService,
                                SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
        this.tmdbTvWebService = tmdbTvWebService;
        Log.d("DAGGER", "MoviesListingInteractorImpl()");
    }

    @Override
    public Observable<List<Movie>> fetchMovies() {

        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            //ramda
            return tmdbWebService.popularMovies().map(MoviesWraper::getMovieList);
            //java
//            return tmdbWebService.popularMovies().map(new Function<MoviesWraper, List<Movie>>() {
//
//                @Override
//                public List<Movie> apply(MoviesWraper moviesWraper) throws Exception {
//                    return moviesWraper.getMovieList();
//                }
//            });
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies().map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(favoritesInteractor.getFavorites());
        }
    }

    /*@Override
    public Observable<List<Movie>> fetchMovies() {
        return Observable.zip(getPoppularMovies(), getTvList(), (movies, tvs) -> {
                ArrayList<Movie> movieArrayList = new ArrayList<>();
                movieArrayList.addAll(movies);
                for (Tv tv : tvs) {
                    Movie m = new Movie();
                    m.setTitle(tv.getName());
                    movieArrayList.add(m);
                }
                return movieArrayList;
        });

    }*/

    public Observable<List<Movie>> getPoppularMovies() {
        return tmdbWebService.popularMovies().map(MoviesWraper::getMovieList);
    }

    public Observable<List<Tv>> getTvList() {
        return tmdbTvWebService.popularTvs().map(TvWraper::getTvList);
    }
}
