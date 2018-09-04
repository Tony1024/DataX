package com.tony.datax.entity.source;

import com.tony.datax.reflection.annotations.db_alias;

/**
 * @Author: Tony
 * @Date: 2018/8/31
 */
@db_alias("source")
public class Source {

    @db_alias("app_key")
    private String	appKey;

    @db_alias("user_id")
    private Integer userId;

    @db_alias("sys_type")
    private Integer sysType;

    @db_alias("request_url")
    private Integer requestUrl;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Integer getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(Integer requestUrl) {
        this.requestUrl = requestUrl;
    }
}
