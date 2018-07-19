package com.radlab.appzumitest.network;

import com.radlab.appzumitest.network.response.bitbucket.BitbucketResponse;
import com.radlab.appzumitest.network.response.github.GithubResponse;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;


public interface Services {

    @GET("/repositories")
    Call<List<GithubResponse>> getGitHubData();

    @GET("/2.0/repositories")
    Call<BitbucketResponse> getBitbucketData();
}
