package me.abir.retrofitrealm.stack_overflow_example.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SiteItem {

    @SerializedName("aliases")
    @Expose
    public List<String> aliases = null;

    @SerializedName("related_sites")
    @Expose
    public List<RelatedSite> relatedSites = null;

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<RelatedSite> getRelatedSites() {
        return relatedSites;
    }

    public void setRelatedSites(List<RelatedSite> relatedSites) {
        this.relatedSites = relatedSites;
    }

    public List<String> getMarkdownExtensions() {
        return markdownExtensions;
    }

    public void setMarkdownExtensions(List<String> markdownExtensions) {
        this.markdownExtensions = markdownExtensions;
    }

    public Integer getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Integer launchDate) {
        this.launchDate = launchDate;
    }

    public Integer getOpenBetaDate() {
        return openBetaDate;
    }

    public void setOpenBetaDate(Integer openBetaDate) {
        this.openBetaDate = openBetaDate;
    }

    public String getSiteState() {
        return siteState;
    }

    public void setSiteState(String siteState) {
        this.siteState = siteState;
    }

    public String getHighResolutionIconUrl() {
        return highResolutionIconUrl;
    }

    public void setHighResolutionIconUrl(String highResolutionIconUrl) {
        this.highResolutionIconUrl = highResolutionIconUrl;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public Integer getClosedBetaDate() {
        return closedBetaDate;
    }

    public void setClosedBetaDate(Integer closedBetaDate) {
        this.closedBetaDate = closedBetaDate;
    }

    @SerializedName("markdown_extensions")
    @Expose
    public List<String> markdownExtensions = null;
    @SerializedName("launch_date")
    @Expose
    public Integer launchDate;
    @SerializedName("open_beta_date")
    @Expose
    public Integer openBetaDate;
    @SerializedName("site_state")
    @Expose
    public String siteState;
    @SerializedName("high_resolution_icon_url")
    @Expose
    public String highResolutionIconUrl;
    @SerializedName("favicon_url")
    @Expose
    public String faviconUrl;
    @SerializedName("icon_url")
    @Expose
    public String iconUrl;
    @SerializedName("audience")
    @Expose
    public String audience;
    @SerializedName("site_url")
    @Expose
    public String siteUrl;
    @SerializedName("api_site_parameter")
    @Expose
    public String apiSiteParameter;
    @SerializedName("logo_url")
    @Expose
    public String logoUrl;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("site_type")
    @Expose
    public String siteType;
    @SerializedName("twitter_account")
    @Expose
    public String twitterAccount;
    @SerializedName("closed_beta_date")
    @Expose
    public Integer closedBetaDate;

}
