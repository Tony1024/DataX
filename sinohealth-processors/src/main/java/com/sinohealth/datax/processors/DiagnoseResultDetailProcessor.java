package com.sinohealth.datax.processors;

import com.google.common.collect.Lists;
import com.sinohealth.datax.common.CommonData;
import com.sinohealth.datax.common.Processor;
import com.sinohealth.datax.entity.common.BasDiagnoseItem;
import com.sinohealth.datax.entity.source.DiagnoseResultDetailS;
import com.sinohealth.datax.entity.target.DiagnoseResultDetailT;
import com.sinohealth.datax.entity.target.DiagnoseResultDetailTList;
import com.sinohealth.datax.utils.TextTrimUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Tony
 * @date 2018/8/8
 **/
public class DiagnoseResultDetailProcessor implements Processor<DiagnoseResultDetailS, DiagnoseResultDetailTList> {

    @Override
    public DiagnoseResultDetailTList dataProcess(DiagnoseResultDetailS diagnoseResultDetailS, DiagnoseResultDetailTList o, CommonData commonData) {
        Map<String, BasDiagnoseItem> basDiagnoseItemMap = commonData.getBasDiagnoseItemMap();
        boolean saveDetailFlag = false;
        List<BasDiagnoseItem> basDiagnoseItems = Lists.newArrayList();
        if (StringUtils.isNotBlank(diagnoseResultDetailS.getDiagnoseResult())) {
            List<String> diagnoses = TextTrimUtils.textSplit(diagnoseResultDetailS.getDiagnoseResult());
            diagnoses.forEach(diagnose -> {
                if (basDiagnoseItemMap.get(diagnose) != null) {
                    basDiagnoseItems.add(basDiagnoseItemMap.get(diagnose));
                }
            });
            if (diagnoses.size() > 0 && diagnoses.size() == basDiagnoseItems.size()) {
                saveDetailFlag = true;
            }
        }

        List<DiagnoseResultDetailT> list = communalDataProcess(diagnoseResultDetailS, basDiagnoseItems, saveDetailFlag);
        o.setDiagnoseResultDetailList(list);
        return o;
    }

    private List<DiagnoseResultDetailT> communalDataProcess(DiagnoseResultDetailS diagnoseResultDetailS, List<BasDiagnoseItem> basDiagnoseItems, boolean saveDetailFlag) {
        List<DiagnoseResultDetailT> diagnoseResultDetailTList = new ArrayList<>();
        if (StringUtils.isNotBlank(diagnoseResultDetailS.getDiagnoseResult()) && saveDetailFlag) {
            basDiagnoseItems.forEach(basDiagnoseItem -> {
                if (StringUtils.isNotBlank(basDiagnoseItem.getDiagnoseComm())) {
                    Arrays.asList(basDiagnoseItem.getDiagnoseComm().split(",")).forEach(o -> {
                        DiagnoseResultDetailT diagnoseResultDetailT = new DiagnoseResultDetailT();
                        diagnoseResultDetailT.setVid(diagnoseResultDetailS.getVid());
                        diagnoseResultDetailT.setDiagnoseResult(basDiagnoseItem.getDiagnose());
                        diagnoseResultDetailT.setDiagnoseResultComm(o);
                        diagnoseResultDetailT.setResultId(diagnoseResultDetailS.getId());
                        diagnoseResultDetailT.setQuestionType(basDiagnoseItem.getQuestionType());
                        diagnoseResultDetailT.setCheckTime(diagnoseResultDetailS.getCheckTime());
                        diagnoseResultDetailT.setBookTime(diagnoseResultDetailS.getBookTime());

                        diagnoseResultDetailTList.add(diagnoseResultDetailT);
                    });
                }
            });
        }

        return diagnoseResultDetailTList;
    }

}
