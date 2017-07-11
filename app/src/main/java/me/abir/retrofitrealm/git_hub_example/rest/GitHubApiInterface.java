package me.abir.retrofitrealm.git_hub_example.rest;

import java.util.List;

import me.abir.retrofitrealm.git_hub_example.model.GithubIssue;
import me.abir.retrofitrealm.git_hub_example.model.GithubRepo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Abir on 11-Jul-17.
 */

public interface GitHubApiInterface {
    String baseUrl = "https://api.github.com";

    @GET("user/repos")
    Call<List<GithubRepo>> getRepos(@Query("per_page") int repoCount);

    @GET("/repos/{owner}/{repo}/issues")
    Call<GithubIssue> getIssues(@Path("owner") String owner, @Path("repo") String repository);

    @POST
    Call<ResponseBody> postComment(@Url String url, @Body GithubIssue issue);
}
