package com.esoxjem.movieguide;

import com.squareup.moshi.Json;

import java.util.List;

public class TvWraper {
    @Json(name = "results")
    private List<Tv> tvList;

    public List<Tv> getTvList() {
        return tvList;
    }
}
