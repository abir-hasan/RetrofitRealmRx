package me.abir.retrofitrealm.stack_overflow_example.rest;

import me.abir.retrofitrealm.stack_overflow_example.model.Sites;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abir Hasan on 02-May-17.
 */

public interface ApiInterface {

    @GET("/sites")
    Call<Sites> getStackExchangeSites();
}
