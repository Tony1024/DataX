package com.sinohealth.datax.processors;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.sinohealth.datax.common.CommonData;
import com.sinohealth.datax.common.Processor;
import com.sinohealth.datax.entity.common.BasTestItem;
import com.sinohealth.datax.entity.common.BasTestResultDiscrete;
import com.sinohealth.datax.entity.source.LisTestResultS;
import com.sinohealth.datax.entity.target.LisTestResultT;

import java.util.List;
import java.util.Map;

/**
 * @author Tony
 * @date 2018/7/27
 **/
public class LisTestResultProcessor implements Processor<LisTestResultS, LisTestResultT> {

    @Override
    public LisTestResultT dataProcess(LisTestResultS lisTestResultS, LisTestResultT o, CommonData commonData) {
        o.setCid(lisTestResultS.getCid());
        o.setVid(lisTestResultS.getVid());
        o.setUnit(lisTestResultS.getUnit());
        o.setItemId(lisTestResultS.getTestitemId());
        o.setItemFt(lisTestResultS.getTestitemFt());
        o.setItemName(lisTestResultS.getTestitemNameC());
        o.setResults(lisTestResultS.getResults());
        o.setNormalL(lisTestResultS.getNormalL());
        o.setNormalH(lisTestResultS.getNormalH());
        o.setBookTime(lisTestResultS.getYysj());

        String itemKey = lisTestResultS.getTestitemFt() + "~" + lisTestResultS.getTestitemNameC();
        boolean isCleaned = false;
        BasTestItem basTestItem = commonData.getBasTestItemMap().get(itemKey);

        if (basTestItem != null) {
            o.setBigCategory(basTestItem.getBigCategory());
            o.setSmallCategory(basTestItem.getSmallCategory());
            o.setItemsNameComm(basTestItem.getItemNameComm());
            o.setGroupId(basTestItem.getGroupId());

            isCleaned= true;
        } else {
            isCleaned = false;
        }

        String unitComm = commonData.getBasTestUnitMap().get(lisTestResultS.getUnit());
        o.setUnitComm(unitComm);

        String results = lisTestResultS.getResults();

        List<BasTestResultDiscrete> testResultDiscretes = commonData.getLisTestResultDiscreteMap()
                .get(o.getItemsNameComm());
        if ("正常".equals(results)) {
            o.setResultsDiscrete("0");
        } else if (testResultDiscretes != null) {
            resultsDiscreteProcess(o, testResultDiscretes, commonData.getResultDiscreteMap());
        }

        if (o.getResultsDiscrete() != null) {
            isCleaned = true;
        }

        o.setCleanStatus(isCleaned ? "0" : "1");
        o.setBookTime(lisTestResultS.getYysj() == null ? DateUtil.date(0) : DateUtil.date(lisTestResultS.getYysj().getTime()));
        o.setCreateTime(DateUtil.date(System.currentTimeMillis()));
        return o;
    }

    public void resultsDiscreteProcess(LisTestResultT lisTestResult, List<BasTestResultDiscrete> testResultDiscretes, Map<String, String> resultDiscreteMap) {
        // 是否为定量指标
        if (NumberUtil.isNumber(lisTestResult.getResults()) && NumberUtil.isNumber(lisTestResult.getNormalL())
                && NumberUtil.isNumber(lisTestResult.getNormalH())) {
            double value = Double.valueOf(lisTestResult.getResults()).doubleValue();
            double normalL = Double.valueOf(lisTestResult.getNormalL()).doubleValue();
            double normalH = Double.valueOf(lisTestResult.getNormalH()).doubleValue();
            Integer discreteType = 0;
            for (BasTestResultDiscrete basTestResultDiscrete : testResultDiscretes) {
                if (basTestResultDiscrete.getDiscreteType() != 2 && basTestResultDiscrete.getDiscreteType() != 7) {
                    discreteType = basTestResultDiscrete.getDiscreteType();
                }
            }
            if (discreteType == 1) {
                if (value <= normalH && value >= normalH * 0.9) {
                    lisTestResult.setResultsDiscrete("1"); // 临界高
                } else if (value > normalH) {
                    lisTestResult.setResultsDiscrete("2"); // 高
                } else {
                    lisTestResult.setResultsDiscrete("0"); // 正常
                }
            } else if (discreteType == 3) {
                if (value > normalH) {
                    lisTestResult.setResultsDiscrete("2"); // 高
                } else {
                    lisTestResult.setResultsDiscrete("0"); // 正常
                }
            } else if (discreteType == 4) {
                if (value <= normalH && value >= normalH * 0.9) {
                    lisTestResult.setResultsDiscrete("1"); // 临界高
                } else if (value >= normalL && value <= normalL * 1.1) {
                    lisTestResult.setResultsDiscrete("-1"); // 临界低
                } else if (value > normalH) {
                    lisTestResult.setResultsDiscrete("2"); // 高
                } else if (value < normalL) {
                    lisTestResult.setResultsDiscrete("-2"); // 低
                } else {
                    lisTestResult.setResultsDiscrete("0"); // 正常
                }
            } else if (discreteType == 5) {
                if (value >= normalL && value <= normalL * 1.1) {
                    lisTestResult.setResultsDiscrete("-1"); // 临界低
                } else if (value < normalL) {
                    lisTestResult.setResultsDiscrete("-2"); // 低
                } else {
                    lisTestResult.setResultsDiscrete("0"); // 正常
                }
            } else if (discreteType == 6) {
                if (value >= normalL && value <= normalH) {
                    lisTestResult.setResultsDiscrete("0"); // 正常
                } else {
                    lisTestResult.setResultsDiscrete("1"); // 异常
                }
            }
        } else if (!NumberUtil.isNumber(lisTestResult.getResults())) {
            lisTestResult.setResultsDiscrete(resultDiscreteMap.get(lisTestResult.getResults()));
        }
    }

}
