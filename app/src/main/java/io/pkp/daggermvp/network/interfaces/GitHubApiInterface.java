package io.pkp.daggermvp.network.interfaces;

import java.util.ArrayList;

import io.pkp.daggermvp.models.Repository;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubApiInterface {
    @GET("/users/{user}/repos")
    Call<ArrayList<Repository>> getRepository(@Path("user") String userName);
}
