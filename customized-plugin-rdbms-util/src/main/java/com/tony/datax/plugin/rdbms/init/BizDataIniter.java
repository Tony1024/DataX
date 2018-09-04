package com.tony.datax.plugin.rdbms.init;

import com.alibaba.datax.plugin.rdbms.util.DataBaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tony
 * @date 2018/7/27
 **/
public class BizDataIniter {

    private static final Logger LOG = LoggerFactory.getLogger(BizDataIniter.class);

    private DataBaseType dataBaseType;
    private String url;
    private String user;
    private String passwd;

    public BizDataIniter(DataBaseType dataBaseType, String url, String user, String passwd) {
        this.dataBaseType = dataBaseType;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

}
