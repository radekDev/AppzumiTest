package com.radlab.appzumitest.mvp;

import com.radlab.appzumitest.network.models.AdapterItem;
import com.radlab.appzumitest.network.response.bitbucket.BitbucketResponse;
import com.radlab.appzumitest.network.response.github.GithubResponse;

import java.util.ArrayList;
import java.util.List;


public interface MainView {

    void sendRequest();

    void showProgress();

    void hideProgress();

    void setAdapter(ArrayList<AdapterItem> adapterItem);
}
