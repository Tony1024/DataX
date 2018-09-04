package com.tony.datax.processors;

import com.tony.datax.common.Processor;
import com.tony.datax.entity.BizData;
import com.tony.datax.entity.source.Source;
import com.tony.datax.entity.target.Target;

/**
 * @Author: Tony
 * @Date: 2018/8/31
 */
public class SourceToTargetProcessor implements Processor<Source,Target> {

    @Override
    public Target dataProcess(Source source, Target o, BizData bizData) {
        o.setAppKey(source.getAppKey());
        o.setSysType(source.getSysType());
        o.setUserId(source.getUserId());
        o.setRequestUrl(source.getRequestUrl());
        return o;
    }
}
