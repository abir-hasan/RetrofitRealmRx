package me.abir.retrofitrealm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import me.abir.retrofitrealm.model.SiteItem;
import me.abir.retrofitrealm.model.Sites;
import me.abir.retrofitrealm.rest.ApiInterface;
import me.abir.retrofitrealm.rest.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiUtils.getEndPoint();
        loadSites();
    }

    private void loadSites() {
        apiInterface.getStackExchangeSites().enqueue(new Callback<Sites>() {
            @Override
            public void onResponse(Call<Sites> call, Response<Sites> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                if (response.isSuccessful()) {
                    List<SiteItem> sites = response.body().getItems();
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
}
