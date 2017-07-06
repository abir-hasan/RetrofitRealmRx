package me.abir.retrofitrealm;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.abir.retrofitrealm.adapter.SitesAdapter;
import me.abir.retrofitrealm.databinding.ActivityMainBinding;
import me.abir.retrofitrealm.model.SiteItem;
import me.abir.retrofitrealm.rest.GetApiResponse;

public class MainActivity extends AppCompatActivity implements GetApiResponse.ApiResponseListener {

    private static final String TAG = "MainActivity";
    private GetApiResponse apiResponse;
    private ActivityMainBinding activityMainBinding;
    private SitesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new SitesAdapter();
        activityMainBinding.rvSites.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rvSites.setAdapter(adapter);

        populateData();
    }

    private void populateData() {
        apiResponse = new GetApiResponse();
        apiResponse.setListener(this);
        apiResponse.loadSites();
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadIcon(ImageView icon, String url, Drawable drawable) {
        Log.w(TAG, "loadIcon() called with:url = [" + url + "]");
        Picasso.with(icon.getContext()).load(url).placeholder(drawable).fit().into(icon);
    }

    @Override
    public void siteListResponse(List<SiteItem> items) {
        adapter.setData(items);
    }
}
