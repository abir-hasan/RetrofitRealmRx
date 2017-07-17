package me.abir.retrofitrealm.git_hub_example.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.ActivityGitHubExampleBinding;

/**
 * Created by Abir on 11-Jul-17.
 */

public class GithubExampleActivity extends AppCompatActivity implements CredentialsDialog.CredentialHandler {

    private static final String TAG = "GithubExampleActivity";
    ActivityGitHubExampleBinding exampleBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleBinding = DataBindingUtil.setContentView(this, R.layout.activity_git_hub_example);

        openCredentialDialog();
    }

    private void openCredentialDialog() {
        CredentialsDialog dialog = new CredentialsDialog();
        dialog.setCredentialHandler(this);
        dialog.show(getSupportFragmentManager(), "CredentialDialog");
    }

    @Override
    public void onCredentialInput(String userName, String passWord) {
        Log.d(TAG, "onCredentialInput() called with: userName = [" + userName + "], passWord = [" + passWord + "]");
    }
}
