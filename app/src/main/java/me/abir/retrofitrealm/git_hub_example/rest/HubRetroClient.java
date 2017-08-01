package me.abir.retrofitrealm.git_hub_example.rest;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import me.abir.retrofitrealm.git_hub_example.model.GithubRepo;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abir on 11-Jul-17.
 */

public class HubRetroClient {

    private static Retrofit retrofit = null;

    private HubRetroClient() {

    }

    public static Retrofit getClient(String username, String password) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(makeClient(username, password))
                    .baseUrl(GitHubApiInterface.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(getCustomGson()))
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient makeClient(final String username, final String password) {

        return new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(@NonNull Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Authorization", Credentials.basic(username, password)).build();
                                return chain.proceed(request);
                            }
                        }).build();
    }

    public static Gson getCustomGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .registerTypeAdapter(GithubRepo.class, new GithubRepoDeserializer())
                .create();
    }
}
