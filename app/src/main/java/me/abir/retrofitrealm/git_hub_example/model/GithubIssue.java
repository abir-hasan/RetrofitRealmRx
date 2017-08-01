package me.abir.retrofitrealm.git_hub_example.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abir on 11-Jul-17.
 */

public class GithubIssue {
    String id;
    String title;
    String comments_url;

    @SerializedName("body")
    String comment;

    @Override
    public String toString() {
        return id + " - " + title;
    }
}
