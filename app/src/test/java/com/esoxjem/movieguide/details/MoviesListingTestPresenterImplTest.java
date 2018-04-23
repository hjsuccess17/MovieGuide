package com.esoxjem.movieguide.details;

import com.esoxjem.movieguide.Movie;
import com.esoxjem.movieguide.Review;
import com.esoxjem.movieguide.RxSchedulerRule;
import com.esoxjem.movieguide.Video;
import com.esoxjem.movieguide.details.MovieDetailsInteractor;
import com.esoxjem.movieguide.details.MovieDetailsPresenterImpl;
import com.esoxjem.movieguide.details.MovieDetailsView;
import com.esoxjem.movieguide.favorites.FavoritesInteractor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoviesListingTestPresenterImplTest {

    @Rule
    public RxSchedulerRule rule = new RxSchedulerRule();
    @Mock
    private MovieDetailsView view;
    @Mock
    private MovieDetailsInteractor movieDetailsInteractor;
    @Mock
    private FavoritesInteractor favoritesInteractor;
    @Mock
    List<Video> videos;
    @Mock
    Movie movie;
    @Mock
    List<Review> reviews;

    private MovieDetailsPresenterImpl movieDetailsPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movieDetailsPresenter = new MovieDetailsPresenterImpl(movieDetailsInteractor, favoritesInteractor);
        movieDetailsPresenter.setView(view);
    }

    @After
    public void teardown() {
        movieDetailsPresenter.destroy();
    }


    @Test
    public void shouldUnfavoriteIfFavoriteTapped() {
        when(movie.getId()).thenReturn("12345");

        when(favoritesInteractor.isFavorite(movie.getId())).thenReturn(true);
        Assert.assertEquals(favoritesInteractor.isFavorite(movie.getId()), true);

        System.out.println("test="+movie.getId());

        movieDetailsPresenter.onFavoriteClick(movie);
        verify(view).showUnFavorited();
    }

    @Test
    public void shouldBeAbleToShowTrailers() {
        when(movie.getId()).thenReturn("12345");
        Observable<List<Video>> responseObservable = Observable.just(videos);
        when(movieDetailsInteractor.getTrailers(movie.getId())).thenReturn(responseObservable);
        when(videos.size()).thenReturn(2);

        System.out.println("test="+videos.size());
        Assert.assertTrue(movieDetailsPresenter.checkSize(videos));
    }
}
