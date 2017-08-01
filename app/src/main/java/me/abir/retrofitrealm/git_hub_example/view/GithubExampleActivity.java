package me.abir.retrofitrealm.git_hub_example.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.abir.retrofitrealm.BaseActivity;
import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.ActivityGitHubExampleBinding;

/**
 * Created by Abir on 11-Jul-17.
 */

public class GithubExampleActivity extends BaseActivity {

    private static final String TAG = "GithubExampleActivity";
    private ActivityGitHubExampleBinding exampleBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleBinding = DataBindingUtil.setContentView(this, R.layout.activity_git_hub_example);
        addFragment(R.id.fragmentContainer, new RepoFragment());
    }
}
