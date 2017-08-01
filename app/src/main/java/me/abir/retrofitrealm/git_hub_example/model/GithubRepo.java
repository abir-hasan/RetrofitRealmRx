package me.abir.retrofitrealm.git_hub_example.model;

/**
 * Created by Abir on 11-Jul-17.
 */

public class GithubRepo {
    public String name;
    public String owner;
    public String url;
    public String language;

    @Override
    public String toString() {
        return (name + " " + url+" "+language);
    }
}
