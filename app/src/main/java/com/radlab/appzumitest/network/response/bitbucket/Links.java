
package com.radlab.appzumitest.network.response.bitbucket;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("watchers")
    @Expose
    private Watchers watchers;
    @SerializedName("branches")
    @Expose
    private Branches branches;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("commits")
    @Expose
    private Commits commits;
    @SerializedName("clone")
    @Expose
    private List<Clone> clone = null;
    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("html")
    @Expose
    private Html html;
    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("hooks")
    @Expose
    private Hooks hooks;
    @SerializedName("forks")
    @Expose
    private Forks forks;
    @SerializedName("downloads")
    @Expose
    private Downloads downloads;
    @SerializedName("issues")
    @Expose
    private Issues issues;
    @SerializedName("pullrequests")
    @Expose
    private Pullrequests pullrequests;

    public Watchers getWatchers() {
        return watchers;
    }

    public void setWatchers(Watchers watchers) {
        this.watchers = watchers;
    }

    public Branches getBranches() {
        return branches;
    }

    public void setBranches(Branches branches) {
        this.branches = branches;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public Commits getCommits() {
        return commits;
    }

    public void setCommits(Commits commits) {
        this.commits = commits;
    }

    public List<Clone> getClone() {
        return clone;
    }

    public void setClone(List<Clone> clone) {
        this.clone = clone;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Html getHtml() {
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Hooks getHooks() {
        return hooks;
    }

    public void setHooks(Hooks hooks) {
        this.hooks = hooks;
    }

    public Forks getForks() {
        return forks;
    }

    public void setForks(Forks forks) {
        this.forks = forks;
    }

    public Downloads getDownloads() {
        return downloads;
    }

    public void setDownloads(Downloads downloads) {
        this.downloads = downloads;
    }

    public Issues getIssues() {
        return issues;
    }

    public void setIssues(Issues issues) {
        this.issues = issues;
    }

    public Pullrequests getPullrequests() {
        return pullrequests;
    }

    public void setPullrequests(Pullrequests pullrequests) {
        this.pullrequests = pullrequests;
    }

}
