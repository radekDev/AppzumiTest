
package com.radlab.appzumitest.network.response.bitbucket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("html")
    @Expose
    private Html_ html;
    @SerializedName("avatar")
    @Expose
    private Avatar_ avatar;

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Html_ getHtml() {
        return html;
    }

    public void setHtml(Html_ html) {
        this.html = html;
    }

    public Avatar_ getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar_ avatar) {
        this.avatar = avatar;
    }

}
