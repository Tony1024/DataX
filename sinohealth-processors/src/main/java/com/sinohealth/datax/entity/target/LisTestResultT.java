package com.sinohealth.datax.entity.target;

import com.sinohealth.datax.reflection.annotations.db_alias;

import java.util.Date;

/**
 * @author Tony
 * @date 2018/7/27
 **/
@db_alias("lis_test_result")
public class LisTestResultT {

    private String cid;
    private String vid;
    @db_alias("item_id")
    private String itemId;
    @db_alias("item_ft")
    private String itemFt;
    @db_alias("item_name")
    private String itemName;
    private String results;
    private String unit;
    @db_alias("normal_l")
    private String normalL;
    @db_alias("normal_h")
    private String normalH;
    @db_alias("big_category")
    private String bigCategory;
    @db_alias("small_category")
    private String smallCategory;
    @db_alias("results_discrete")
    private String resultsDiscrete;
    @db_alias("unit_comm")
    private String unitComm;
    @db_alias("items_name_comm")
    private String itemsNameComm;
    @db_alias("group_id")
    private Integer groupId;
    @db_alias("book_time")
    private Date bookTime;
    @db_alias("clean_status")
    private String cleanStatus;
    @db_alias("create_time")
    private Date createTime;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemFt() {
        return itemFt;
    }

    public void setItemFt(String itemFt) {
        this.itemFt = itemFt;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNormalL() {
        return normalL;
    }

    public void setNormalL(String normalL) {
        this.normalL = normalL;
    }

    public String getNormalH() {
        return normalH;
    }

    public void setNormalH(String normalH) {
        this.normalH = normalH;
    }

    public String getBigCategory() {
        return bigCategory;
    }

    public void setBigCategory(String bigCategory) {
        this.bigCategory = bigCategory;
    }

    public String getSmallCategory() {
        return smallCategory;
    }

    public void setSmallCategory(String smallCategory) {
        this.smallCategory = smallCategory;
    }

    public String getResultsDiscrete() {
        return resultsDiscrete;
    }

    public void setResultsDiscrete(String resultsDiscrete) {
        this.resultsDiscrete = resultsDiscrete;
    }

    public String getUnitComm() {
        return unitComm;
    }

    public void setUnitComm(String unitComm) {
        this.unitComm = unitComm;
    }

    public String getItemsNameComm() {
        return itemsNameComm;
    }

    public void setItemsNameComm(String itemsNameComm) {
        this.itemsNameComm = itemsNameComm;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}