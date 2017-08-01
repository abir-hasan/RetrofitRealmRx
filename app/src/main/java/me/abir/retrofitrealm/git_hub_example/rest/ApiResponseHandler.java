package me.abir.retrofitrealm.git_hub_example.rest;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.abir.retrofitrealm.git_hub_example.model.GithubRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abir on 18-Jul-17.
 */

public class ApiResponseHandler {

    private static final String TAG = "ApiResponseHandler";
    private GitHubApiInterface apiInterface;
    private ApiResponseListener listener;

    public ApiResponseHandler(String userName,String passWord) {
        apiInterface = HubRetroClient.getClient(userName, passWord).create(GitHubApiInterface.class);
    }

    public void loadRepos() {
        final List<GithubRepo> repos = new ArrayList<>();
        apiInterface.getRepos(10).enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                if (response.isSuccessful()) {
                    repos.addAll(response.body());
                    listener.repoListResponse(repos);
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

            }
        });
    }


    public void setListener(ApiResponseListener listener) {
        this.listener = listener;
    }

    public interface ApiResponseListener {
        void repoListResponse(List<GithubRepo> items);
    }
}
