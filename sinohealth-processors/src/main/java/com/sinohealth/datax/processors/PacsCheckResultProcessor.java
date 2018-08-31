package com.sinohealth.datax.processors;

import cn.hutool.core.date.DateUtil;
import com.sinohealth.datax.common.CommonData;
import com.sinohealth.datax.common.Processor;
import com.sinohealth.datax.entity.common.BasCheckItem;
import com.sinohealth.datax.entity.common.BasCheckItemInit;
import com.sinohealth.datax.entity.source.PacsCheckResultS;
import com.sinohealth.datax.entity.target.PacsCheckResultT;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Tony
 * @date 2018/8/7
 **/
public class PacsCheckResultProcessor implements Processor<PacsCheckResultS, PacsCheckResultT> {

    @Override
    public PacsCheckResultT dataProcess(PacsCheckResultS pacsCheckResultS, PacsCheckResultT o, CommonData commonData) {
        BasCheckItem checkItem = commonData.getBasCheckItemMap().get(pacsCheckResultS.getFieldComment());

        PacsCheckResultT pacsCheckResult = new PacsCheckResultT();
        pacsCheckResult.setVid(pacsCheckResultS.getVid());
        pacsCheckResult.setCid(pacsCheckResultS.getCid());
        pacsCheckResult.setItemId(pacsCheckResultS.getItemId());
        pacsCheckResult.setItemName(pacsCheckResultS.getFieldComment());
        pacsCheckResult.setResults(pacsCheckResultS.getFieldResults());
        pacsCheckResult.setNormalL(pacsCheckResultS.getZczXx());
        pacsCheckResult.setNormalH(pacsCheckResultS.getZczSx());
        pacsCheckResult.setUnit(pacsCheckResultS.getDw());
        pacsCheckResult.setInitResult(pacsCheckResultS.getInitResults());
        for (BasCheckItemInit bcii : commonData.getBasCheckItemInitList()) {
            if (pacsCheckResult.getInitResult() != null && bcii.getInitResult() != null
                    && bcii.getInitResult().equals(pacsCheckResult.getInitResult())) {
                pacsCheckResult.setInitResultComm(bcii.getInitResultComm());
                break;
            }
        }
        pacsCheckResult.setInFactory(pacsCheckResultS.getInFactory());
        pacsCheckResult.setCreateTime(DateUtil.parse(pacsCheckResultS.getOpDatetime()));
        if (pacsCheckResultS.getYysj() != null) {
            pacsCheckResult.setBookTime(DateUtil.date(pacsCheckResultS.getYysj().getTime()));
        } else {
            pacsCheckResult.setBookTime(DateUtil.date(0));
        }
        pacsCheckResult.setUnitComm(commonData.getBasTestUnitMap().get(pacsCheckResultS.getDw()));
        if (StringUtils.isNotBlank(pacsCheckResult.getItemName())) {
            if (checkItem != null) {
                pacsCheckResult.setItemNameComm(checkItem.getFieldComm());
            }
            // 暂不考虑单位未标准化的数据清洗问题
            if (/* StringUtils.isNotBlank(pacsCheckResult.getUnitComm()) && */
                    StringUtils.isNotBlank(pacsCheckResult.getItemNameComm())) {
                pacsCheckResult.setCleanStatus(0);
            } else {
                pacsCheckResult.setCleanStatus(1);
            }
        } else {
            pacsCheckResult.setCleanStatus(0);
        }

        return pacsCheckResult;
    }
}
