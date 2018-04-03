package com.esoxjem.movieguide.listing;

import android.util.Log;

import com.esoxjem.movieguide.favorites.FavoritesInteractor;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;
import com.esoxjem.movieguide.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule {

    public ListingModule() {
        Log.d("DAGGER", "ListingModule()");
    }

    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          TmdbWebService tmdbWebService,
                                                          SortingOptionStore sortingOptionStore) {
        Log.d("DAGGER", "provideMovieListingInteractor()");
        return new MoviesListingInteractorImpl(favoritesInteractor, tmdbWebService, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        Log.d("DAGGER", "provideMovieListingPresenter()");
        return new MoviesListingPresenterImpl(interactor);
    }
}
