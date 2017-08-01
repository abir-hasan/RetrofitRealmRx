package me.abir.retrofitrealm.git_hub_example.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.AdapterRepoNameBinding;
import me.abir.retrofitrealm.git_hub_example.model.GithubRepo;

/**
 * Created by Abir on 01-Aug-17.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private static final String TAG = "RepoAdapter";
    private List<GithubRepo> repoList = new ArrayList<>();

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterRepoNameBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_repo_name, parent, false);
        return new RepoViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        AdapterRepoNameBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setRepoItem(repoList.get(position));
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public void setData(List<GithubRepo> repoList) {
        this.repoList.clear();
        this.repoList.addAll(repoList);
        notifyDataSetChanged();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {


        public RepoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
