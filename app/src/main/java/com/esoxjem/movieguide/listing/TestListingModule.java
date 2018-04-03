package com.esoxjem.movieguide.listing;

import android.util.Log;

import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lykhappy on 2018-04-01.
 */
public class TestListingModule extends ListingModule {

    public TestListingModule() {
        super();
        Log.d("DAGGER", "TestListingModule()");
    }

    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor, TmdbWebService tmdbWebService, SortingOptionStore sortingOptionStore) {
        Log.d("DAGGER", "TestListingModule#provideTestMovieListingInteractor()");
        return new TestMoviesListingInteractorImpl(favoritesInteractor, tmdbWebService, sortingOptionStore);
    }

    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return super.provideMovieListingPresenter(interactor);
    }

}
