package me.abir.retrofitrealm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedSite {

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("relation")
    @Expose
    public String relation;
    @SerializedName("api_site_parameter")
    @Expose
    public String apiSiteParameter;
    @SerializedName("site_url")
    @Expose
    public String siteUrl;
    @SerializedName("name")
    @Expose
    public String name;

}
