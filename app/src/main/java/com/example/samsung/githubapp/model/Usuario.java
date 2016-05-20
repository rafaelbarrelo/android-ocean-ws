package com.example.samsung.githubapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samsung on 16/05/2016.
 */
public class Usuario {

    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String name;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
