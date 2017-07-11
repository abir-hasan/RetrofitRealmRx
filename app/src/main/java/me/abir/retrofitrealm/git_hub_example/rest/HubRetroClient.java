package me.abir.retrofitrealm.git_hub_example.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abir on 11-Jul-17.
 */

public class HubRetroClient {

    private static Retrofit retrofit = null;

    private HubRetroClient() {

    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(GitHubApiInterface.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
