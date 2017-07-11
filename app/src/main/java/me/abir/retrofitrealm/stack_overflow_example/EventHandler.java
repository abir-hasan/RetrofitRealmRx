package me.abir.retrofitrealm.stack_overflow_example;

import android.content.Intent;
import android.util.Log;
import android.view.View;

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
}
