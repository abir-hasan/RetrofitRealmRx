package me.abir.retrofitrealm;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Abir on 01-Aug-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected void addFragment(int containerId, Fragment fragment, String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();
    }

    protected void addFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .disallowAddToBackStack()
                .commit();
    }

    protected void replaceFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commit();
    }

    protected void replaceFragment(int containerId, Fragment fragment, String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }
}
