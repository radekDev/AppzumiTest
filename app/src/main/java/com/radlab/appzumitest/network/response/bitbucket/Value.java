
package com.radlab.appzumitest.network.response.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("scm")
    @Expose
    private String scm;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("has_wiki")
    @Expose
    private Boolean hasWiki;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("fork_policy")
    @Expose
    private String forkPolicy;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("mainbranch")
    @Expose
    private Mainbranch mainbranch;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("has_issues")
    @Expose
    private Boolean hasIssues;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("is_private")
    @Expose
    private Boolean isPrivate;
    @SerializedName("description")
    @Expose
    private String description;

    public String getScm() {
        return scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getForkPolicy() {
        return forkPolicy;
    }

    public void setForkPolicy(String forkPolicy) {
        this.forkPolicy = forkPolicy;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Mainbranch getMainbranch() {
        return mainbranch;
    }

    public void setMainbranch(Mainbranch mainbranch) {
        this.mainbranch = mainbranch;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
