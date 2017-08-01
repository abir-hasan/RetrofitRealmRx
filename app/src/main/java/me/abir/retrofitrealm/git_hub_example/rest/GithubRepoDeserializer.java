package me.abir.retrofitrealm.git_hub_example.rest;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import me.abir.retrofitrealm.git_hub_example.model.GithubRepo;

/**
 * Created by Abir on 18-Jul-17.
 */

public class GithubRepoDeserializer implements JsonDeserializer<GithubRepo> {

    private static final String TAG = "GithubRepoDeserializer";

    @Override
    public GithubRepo deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context) throws JsonParseException {
        Log.d(TAG, "deserialize() called with: json = [" + json + "], typeOfT = [" + typeOfT + "], context = [" + context + "]");

        GithubRepo githubRepo = new GithubRepo();

        JsonObject repoJsonObject = json.getAsJsonObject();
        githubRepo.name = repoJsonObject.get("name").getAsString();
        githubRepo.url = repoJsonObject.get("url").getAsString();
        githubRepo.language = repoJsonObject.get("language").getAsString();

        JsonElement ownerJsonElement = repoJsonObject.get("owner");
        JsonObject ownerJsonObject = ownerJsonElement.getAsJsonObject();
        githubRepo.owner = ownerJsonObject.get("login").getAsString();


        return githubRepo;
    }
}
