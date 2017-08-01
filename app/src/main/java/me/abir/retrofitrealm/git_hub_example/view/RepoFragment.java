package me.abir.retrofitrealm.git_hub_example.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.FragmentRepoBinding;
import me.abir.retrofitrealm.git_hub_example.adapter.RepoAdapter;
import me.abir.retrofitrealm.git_hub_example.model.GithubRepo;
import me.abir.retrofitrealm.git_hub_example.rest.ApiResponseHandler;

/**
 * Created by Abir on 01-Aug-17.
 */

public class RepoFragment extends Fragment implements CredentialsDialog.CredentialHandler, ApiResponseHandler.ApiResponseListener {
    private static final String TAG = "RepoFragment";
    private Context context;
    private RepoAdapter adapter;

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRepoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_repo, container, false);
        openCredentialDialog();
        initViews(binding);
        return binding.getRoot();
    }

    private void initViews(FragmentRepoBinding binding) {
        binding.rvRepos.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RepoAdapter();
        binding.rvRepos.setAdapter(adapter);
    }


    private void openCredentialDialog() {
        CredentialsDialog dialog = new CredentialsDialog();
        dialog.setCredentialHandler(this);
        dialog.show(getFragmentManager(), "CredentialDialog");
    }

    @Override
    public void onCredentialInput(String userName, String passWord) {
        Log.d(TAG, "onCredentialInput() called with: userName = [" + userName + "], passWord = ["
                + passWord + "]");
        ApiResponseHandler handler = new ApiResponseHandler(userName, passWord);
        handler.setListener(this);
        handler.loadRepos();
    }

    @Override
    public void repoListResponse(List<GithubRepo> items) {
        Log.d(TAG, "repoListResponse() called with: items = [" + items + "]");
        adapter.setData(items);
    }
}
