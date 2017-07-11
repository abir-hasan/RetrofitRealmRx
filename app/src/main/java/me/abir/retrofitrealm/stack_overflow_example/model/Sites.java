package me.abir.retrofitrealm.stack_overflow_example.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sites {

    @SerializedName("items")
    @Expose
    public List<SiteItem> items = null;
    @SerializedName("has_more")
    @Expose
    public Boolean hasMore;

    public List<SiteItem> getItems() {
        return items;
    }

    public void setItems(List<SiteItem> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    @SerializedName("quota_max")
    @Expose

    public Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    public Integer quotaRemaining;

}
