package me.abir.retrofitrealm.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abir Hasan on 06-Jul-17.
 */

public class RetrofitClient {
    public static final String BASE_URL_STACK_EXCHANGE = "https://api.stackexchange.com/2.2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_STACK_EXCHANGE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
