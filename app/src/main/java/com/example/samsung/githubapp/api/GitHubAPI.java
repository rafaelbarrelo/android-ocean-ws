package com.example.samsung.githubapp.api;

/**
 * Created by samsung on 16/05/2016.
 */

import com.example.samsung.githubapp.model.Usuario;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubAPI {

    @GET("/users/{user}")
    public void getUser(@Path("user") String user, Callback<Usuario> response);
}
