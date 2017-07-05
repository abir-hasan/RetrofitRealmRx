package me.abir.retrofitrealm.rest;

/**
 * Created by Abir Hasan123 on 06-Jul-17.
 */

public class ApiUtils {

    public static ApiInterface getEndPoint() {
        return RetrofitClient.getClient().create(ApiInterface.class);
    }
}
