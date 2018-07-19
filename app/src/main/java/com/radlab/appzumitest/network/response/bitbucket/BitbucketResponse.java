
package com.radlab.appzumitest.network.response.bitbucket;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitbucketResponse {

    @SerializedName("pagelen")
    @Expose
    private Integer pagelen;
    @SerializedName("values")
    @Expose
    private List<Value> values = null;
    @SerializedName("next")
    @Expose
    private String next;

    public Integer getPagelen() {
        return pagelen;
    }

    public void setPagelen(Integer pagelen) {
        this.pagelen = pagelen;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
