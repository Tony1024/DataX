package com.sinohealth.datax.processors;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.google.common.collect.Lists;
import com.sinohealth.datax.common.CommonData;
import com.sinohealth.datax.common.Processor;
import com.sinohealth.datax.entity.common.BasDiagnoseItem;
import com.sinohealth.datax.entity.source.DiagnoseResultS;
import com.sinohealth.datax.entity.target.DiagnoseResultT;
import com.sinohealth.datax.utils.TextTrimUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author Tony
 * @date 2018/8/7
 **/
public class DiagnoseResultProcessor implements Processor<DiagnoseResultS, DiagnoseResultT> {

    private static final Logger logger = LoggerFactory.getLogger(DiagnoseResultProcessor.class);

    @Override
    public DiagnoseResultT dataProcess(DiagnoseResultS diagnoseResultS, DiagnoseResultT o, CommonData commonData) {
        Map<String, BasDiagnoseItem> basDiagnoseItemMap = commonData.getBasDiagnoseItemMap();
        boolean saveDetailFlag = false;
        List<BasDiagnoseItem> basDiagnoseItems = Lists.newArrayList();
        long resultId = IdWorker.getId();
        if (StringUtils.isNotBlank(diagnoseResultS.getZdNr())) {
            List<String> diagnoses = TextTrimUtils.textSplit(diagnoseResultS.getZdNr());
            diagnoses.forEach(diagnose -> {
                if (basDiagnoseItemMap.get(diagnose) != null) {
                    basDiagnoseItems.add(basDiagnoseItemMap.get(diagnose));
                }
            });
            if (diagnoses.size() > 0 && diagnoses.size() == basDiagnoseItems.size()) {
                saveDetailFlag = true;
            }
        }

        return communalDataProcess(diagnoseResultS, saveDetailFlag, resultId);
    }

    private DiagnoseResultT communalDataProcess(DiagnoseResultS diagnoseResultS,
                                                  boolean saveDetailFlag, Long resultId) {
        DiagnoseResultT diagnoseResult = new DiagnoseResultT();
        diagnoseResult.setId(resultId);
        diagnoseResult.setVid(diagnoseResultS.getVid());
        diagnoseResult.setDiagnoseResult(diagnoseResultS.getZdNr());
        diagnoseResult.setItemId(diagnoseResultS.getItemId());
        diagnoseResult.setItemMs(diagnoseResultS.getItemMs());
        diagnoseResult.setItemMsBak(diagnoseResultS.getItemMsZb());
        diagnoseResult.setTempContent(diagnoseResultS.getMbnr());
        diagnoseResult.setIsIll(diagnoseResultS.getSfjb());
        diagnoseResult.setDiagnoseSuggest(diagnoseResultS.getJybt());
        diagnoseResult.setMedicalExplain(diagnoseResultS.getYxjs());
        diagnoseResult.setCauseEffect(diagnoseResultS.getYyhg());
        diagnoseResult.setSuggest(diagnoseResultS.getYxjy());
        diagnoseResult.setCheckTime(diagnoseResultS.getDjsj());
        diagnoseResult.setPosition(diagnoseResultS.getYcbw());
        diagnoseResult.setInFactory(diagnoseResultS.getInFactory());
        diagnoseResult.setDoctor(diagnoseResultS.getCzys());
        diagnoseResult.setResults(diagnoseResultS.getResults());
        diagnoseResult.setNormalRange(diagnoseResultS.getFw());
        diagnoseResult.setItemTitle(diagnoseResultS.getTdbgBt());
        diagnoseResult.setIllName(diagnoseResultS.getJbBmMc());
        if (diagnoseResultS.getYysj() != null) {
            diagnoseResult.setBookTime(DateUtil.date(diagnoseResultS.getYysj().getTime()));
        } else {
            diagnoseResult.setBookTime(DateUtil.date(0));
        }
        if (StringUtils.isNotBlank(diagnoseResult.getDiagnoseResult()) && saveDetailFlag) {
            diagnoseResult.setCleanStatus(0);
        } else {
            if (StringUtils.isNotBlank(diagnoseResultS.getZdNr())) {
                diagnoseResult.setCleanStatus(1);
            } else {
                diagnoseResult.setCleanStatus(0);
            }
        }

        return diagnoseResult;
    }

}
