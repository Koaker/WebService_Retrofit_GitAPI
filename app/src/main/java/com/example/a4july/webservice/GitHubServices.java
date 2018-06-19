package com.example.a4july.webservice;

import android.widget.EditText;

import com.example.a4july.webservice.models.Repo;
import static com.example.a4july.webservice.MainActivity.user;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubServices {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(
            @Path("user") String user);
}
