package com.radlab.appzumitest.mvp;

import com.radlab.appzumitest.network.models.AdapterItem;
import com.radlab.appzumitest.network.response.bitbucket.BitbucketResponse;
import com.radlab.appzumitest.network.response.bitbucket.Value;
import com.radlab.appzumitest.network.response.github.GithubResponse;

import java.util.ArrayList;
import java.util.List;


public class PresenterImpl implements Presenter {

    private ArrayList<AdapterItem> adapterList = new ArrayList<>();
    private MainView _mainView;

    public PresenterImpl(MainView mainView) {
        _mainView = mainView;
    }

    @Override
    public void collectData() {
        if (_mainView != null) {
            _mainView.sendRequest();
            _mainView.showProgress();
        }
    }

    @Override
    public void onGithubDataReceive(List<GithubResponse> githubResponses) {

        for (GithubResponse item : githubResponses) {
            adapterList.add(new AdapterItem(item.getName(), item.getOwner().getLogin(), item.getOwner().getAvatarUrl(), item.getDescription()));
        }
    }

    @Override
    public void onBitbucketDataReceive(BitbucketResponse bitbucketResponse) {
        for (Value item : bitbucketResponse.getValues()) {
            adapterList.add(new AdapterItem(item.getName(), item.getOwner().getUsername(), item.getLinks().getAvatar().getHref(), item.getDescription(), true));
        }
        onDataReceive(adapterList);
    }

    @Override
    public void onDataReceive(ArrayList<AdapterItem> adapterItems) {
        if (_mainView != null) {
            _mainView.setAdapter(adapterItems);
            _mainView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        _mainView = null;
    }
}
