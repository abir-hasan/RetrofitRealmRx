package me.abir.retrofitrealm.stack_overflow_example.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.ActivityStackSitesBinding;
import me.abir.retrofitrealm.stack_overflow_example.adapter.SitesAdapter;
import me.abir.retrofitrealm.stack_overflow_example.model.SiteItem;
import me.abir.retrofitrealm.stack_overflow_example.rest.GetApiResponse;

/**
 * Created by Abir on 11-Jul-17.
 */

public class StackSitesActivity extends AppCompatActivity implements GetApiResponse.ApiResponseListener{

    private static final String TAG = "StackSitesActivity";
    private ActivityStackSitesBinding activityStackSitesBinding;
    private GetApiResponse apiResponse;
    private SitesAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStackSitesBinding = DataBindingUtil.setContentView(this, R.layout.activity_stack_sites);

        adapter = new SitesAdapter();
        activityStackSitesBinding.rvSites.setLayoutManager(new LinearLayoutManager(this));
        activityStackSitesBinding.rvSites.setAdapter(adapter);

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
