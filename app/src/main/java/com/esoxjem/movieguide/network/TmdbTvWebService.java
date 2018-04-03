package com.esoxjem.movieguide.network;

import com.esoxjem.movieguide.MoviesWraper;
import com.esoxjem.movieguide.TvWraper;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TmdbTvWebService {

    @GET("3/tv/popular")
    Observable<TvWraper> popularTvs();
}
