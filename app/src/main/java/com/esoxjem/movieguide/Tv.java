package com.esoxjem.movieguide;

import com.squareup.moshi.Json;

public class Tv {
    @Json(name = "name")
    private String name;


    public String getName() {
        return name;
    }
}
