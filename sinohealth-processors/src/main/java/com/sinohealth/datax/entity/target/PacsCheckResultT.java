package com.sinohealth.datax.entity.target;

import com.sinohealth.datax.reflection.annotations.db_alias;

import java.util.Date;

/**
 * @author Tony
 * @date 2018/8/7
 **/
@db_alias("pacs_check_result")
public class PacsCheckResultT {

    /**
     * 体检编号
     */
    private String				vid;
    /**
     * 体检案例编号
     */
    private String				cid;
    /**
     * 项目编号
     */
    @db_alias("item_id")
    private String				itemId;
    /**
     * 项目名称
     */
    @db_alias("item_name")
    private String				itemName;
    /**
     * 项目标准名称
     */
    @db_alias("item_name_comm")
    private String				itemNameComm;
    /**
     * 检查结果
     */
    private String				results;
    /**
     * 参考值下限
     */
    @db_alias("normal_l")
    private String				normalL;
    /**
     * 参考值上限
     */
    @db_alias("normal_h")
    private String				normalH;
    /**
     * 单位
     */
    private String				unit;
    /**
     * 标准单位
     */
    @db_alias("unit_comm")
    private String				unitComm;
    /**
     * 初始化结果
     */
    @db_alias("init_result")
    private String				initResult;

    @db_alias("init_result_comm")
    private String				initResultComm;
    /**
     * 门店编号
     */
    @db_alias("in_factory")
    private String				inFactory;
    /**
     * 创建时间
     */
    @db_alias("create_time")
    private Date createTime;
    /**
     * 清洗状态 0:完成 1:未识别 2:机器识别
     */
    @db_alias("clean_status")
    private Integer				cleanStatus;
    /**
     * 预约时间
     */
    @db_alias("book_time")
    private Date bookTime;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNameComm() {
        return itemNameComm;
    }

    public void setItemNameComm(String itemNameComm) {
        this.itemNameComm = itemNameComm;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitComm() {
        return unitComm;
    }

    public void setUnitComm(String unitComm) {
        this.unitComm = unitComm;
    }

    public String getInitResult() {
        return initResult;
    }

    public void setInitResult(String initResult) {
        this.initResult = initResult;
    }

    public String getInitResultComm() {
        return initResultComm;
    }

    public void setInitResultComm(String initResultComm) {
        this.initResultComm = initResultComm;
    }

    public String getInFactory() {
        return inFactory;
    }

    public void setInFactory(String inFactory) {
        this.inFactory = inFactory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(Integer cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }
}
