package me.abir.retrofitrealm.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.AdapterExchangeSitesBinding;
import me.abir.retrofitrealm.model.SiteItem;

/**
 * Created by Abir on 06-Jul-17.
 */

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.SiteViewHolder> {
    private static final String TAG = "SitesAdapter";
    private List<SiteItem> siteItems = new ArrayList<>();

    @Override
    public SiteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterExchangeSitesBinding binding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.adapter_exchange_sites, parent, false);
        return new SiteViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(SiteViewHolder holder, int position) {
        AdapterExchangeSitesBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setSiteItem(siteItems.get(position));
    }

    @Override
    public int getItemCount() {
        return siteItems.size();
    }

    public void setData(List<SiteItem> items) {
        siteItems.clear();
        siteItems.addAll(items);
        notifyDataSetChanged();
    }

    class SiteViewHolder extends RecyclerView.ViewHolder {

        public SiteViewHolder(View itemView) {
            super(itemView);
        }
    }
}
