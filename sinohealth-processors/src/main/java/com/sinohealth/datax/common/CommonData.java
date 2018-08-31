package com.sinohealth.datax.common;

import com.sinohealth.datax.entity.common.*;

import java.util.List;
import java.util.Map;

/**
 * @author Tony
 * @date 2018/7/27
 **/
public class CommonData {

    private Map<String, BasTestItem> basTestItemMap;
    private Map<String, String> basTestUnitMap;
    private Map<String, List<BasTestResultDiscrete>> lisTestResultDiscreteMap;
    private Map<String, String> resultDiscreteMap;
    private Map<String, BasCheckItem> basCheckItemMap;
    private List<BasCheckItemInit> basCheckItemInitList;
    private Map<String, BasDiagnoseItem> basDiagnoseItemMap;

    public Map<String, BasTestItem> getBasTestItemMap() {
        return basTestItemMap;
    }

    public void setBasTestItemMap(Map<String, BasTestItem> basTestItemMap) {
        this.basTestItemMap = basTestItemMap;
    }

    public Map<String, String> getBasTestUnitMap() {
        return basTestUnitMap;
    }

    public void setBasTestUnitMap(Map<String, String> basTestUnitMap) {
        this.basTestUnitMap = basTestUnitMap;
    }

    public Map<String, List<BasTestResultDiscrete>> getLisTestResultDiscreteMap() {
        return lisTestResultDiscreteMap;
    }

    public void setLisTestResultDiscreteMap(Map<String, List<BasTestResultDiscrete>> lisTestResultDiscreteMap) {
        this.lisTestResultDiscreteMap = lisTestResultDiscreteMap;
    }

    public Map<String, String> getResultDiscreteMap() {
        return resultDiscreteMap;
    }

    public void setResultDiscreteMap(Map<String, String> resultDiscreteMap) {
        this.resultDiscreteMap = resultDiscreteMap;
    }

    public Map<String, BasCheckItem> getBasCheckItemMap() {
        return basCheckItemMap;
    }

    public void setBasCheckItemMap(Map<String, BasCheckItem> basCheckItemMap) {
        this.basCheckItemMap = basCheckItemMap;
    }

    public List<BasCheckItemInit> getBasCheckItemInitList() {
        return basCheckItemInitList;
    }

    public void setBasCheckItemInitList(List<BasCheckItemInit> basCheckItemInitList) {
        this.basCheckItemInitList = basCheckItemInitList;
    }

    public Map<String, BasDiagnoseItem> getBasDiagnoseItemMap() {
        return basDiagnoseItemMap;
    }

    public void setBasDiagnoseItemMap(Map<String, BasDiagnoseItem> basDiagnoseItemMap) {
        this.basDiagnoseItemMap = basDiagnoseItemMap;
    }
}
