package com.radlab.appzumitest.mvp;

import com.radlab.appzumitest.network.models.AdapterItem;
import com.radlab.appzumitest.network.response.bitbucket.BitbucketResponse;
import com.radlab.appzumitest.network.response.github.GithubResponse;

import java.util.ArrayList;
import java.util.List;


public interface Presenter {

    void collectData();

    void onGithubDataReceive(List<GithubResponse> githubResponses);

    void onBitbucketDataReceive(BitbucketResponse bitbucketResponse);

    void onDataReceive(ArrayList<AdapterItem> adapterItems);

    void onDestroy();
}
