package me.abir.retrofitrealm;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import me.abir.retrofitrealm.git_hub_example.view.GithubExampleActivity;
import me.abir.retrofitrealm.stack_overflow_example.view.StackSitesActivity;

/**
 * Created by Abir on 11-Jul-17.
 */

public class EventHandler {

    private static final String TAG = "EventHandler";

    public void onHandleClick(View view) {
        Log.d(TAG, "onHandleClick() called with: view = [" + view + "]");
        view.getContext().startActivity(new Intent(view.getContext(), StackSitesActivity.class));
    }

    public void onHandleClick(View view, String value) {
        Log.d(TAG, "onHandleClick() called with: view = [" + view + "], value = [" + value + "]");
        view.getContext().startActivity(new Intent(view.getContext(), StackSitesActivity.class));
    }

    public void onGitHubButtonClick(View view) {
        Log.d(TAG, "onGitHubButtonClick() called with: view = [" + view + "]");
        view.getContext().startActivity(new Intent(view.getContext(), GithubExampleActivity.class));
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadIcon(ImageView icon, String url, Drawable drawable) {
        Log.w(TAG, "loadIcon() called with:url = [" + url + "]");
        Picasso.with(icon.getContext()).load(url).placeholder(drawable).fit().into(icon);
    }
}
