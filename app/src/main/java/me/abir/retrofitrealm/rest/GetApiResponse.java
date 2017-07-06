package me.abir.retrofitrealm.rest;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.abir.retrofitrealm.model.SiteItem;
import me.abir.retrofitrealm.model.Sites;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abir on 06-Jul-17.
 */

public class GetApiResponse {

    private static final String TAG = "GetApiResponse";
    private ApiInterface apiInterface;
    private ApiResponseListener listener;

    public GetApiResponse() {
        apiInterface = ApiUtils.getEndPoint();
    }

    public void loadSites() {

        final List<SiteItem> sites = new ArrayList<>();

        apiInterface.getStackExchangeSites().enqueue(new Callback<Sites>() {
            @Override
            public void onResponse(Call<Sites> call, Response<Sites> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                if (response.isSuccessful()) {
                    sites.addAll(response.body().getItems());
                    listener.siteListResponse(sites);
                    int index = 0;
                    for (SiteItem i : sites) {
                        Log.w(TAG, "index: " + index + " name: " + i.getName());
                        index++;
                    }
                }

            }

            @Override
            public void onFailure(Call<Sites> call, Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });
    }


    public void setListener(ApiResponseListener listener) {
        this.listener = listener;
    }

    public interface ApiResponseListener {
        void siteListResponse(List<SiteItem> items);
    }
}
