package com.radlab.appzumitest.network.models;

import java.io.Serializable;

public class AdapterItem implements Serializable{

    private String repoName;
    private String userName;
    private String avatarUrl;
    private String repoDesc;
    private boolean isBitbucket = false;

    public AdapterItem(String repoName, String userName, String avatarUrl, String repoDesc) {
        this.repoName = repoName;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.repoDesc = repoDesc;
    }

    public AdapterItem(String repoName, String userName, String avatarUrl, String repoDesc, boolean isBitbucket) {
        this.repoName = repoName;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.repoDesc = repoDesc;
        this.isBitbucket = isBitbucket;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getRepoDesc() {
        return repoDesc;
    }

    public boolean isBitbucket() {
        return isBitbucket;
    }
}
