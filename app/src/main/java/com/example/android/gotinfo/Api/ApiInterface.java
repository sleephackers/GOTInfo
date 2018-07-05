package com.example.android.gotinfo.Api;

import com.example.android.gotinfo.NameResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public abstract interface ApiInterface {
@GET("characters/{name}")
    Call<NameResponse> getCharacter(@Path("name") String name);
}
