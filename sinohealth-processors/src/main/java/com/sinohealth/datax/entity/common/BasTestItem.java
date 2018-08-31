package com.sinohealth.datax.entity.common;

import com.sinohealth.datax.reflection.annotations.db_alias;

/**
 * 检验结果Result
 * 
 * @author ld
 * @version 2017-07-05
 */
public class BasTestItem {

	private Integer				id;
	@db_alias("testitem_name_c")
	private String testitemNameC;
	@db_alias("testitem_ft")
	private String				testitemFt;
	@db_alias("big_category")
	private String				bigCategory;				// 大类
	@db_alias("small_category")
	private String				smallCategory;				// 小类
	@db_alias("item_name_comm")
	private String				itemNameComm;				// 中文标准名称
	@db_alias("clean_status")
	private Integer				cleanStatus;				// 清洗状态
	@db_alias("del_flag")
	private Integer				delFlag;					// 删除标记
	@db_alias("group_id")
	private Integer				groupId;					// 行号
	private Integer				items;						// 单项个数

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestitemNameC() {
		return testitemNameC;
	}

	public void setTestitemNameC(String testitemNameC) {
		this.testitemNameC = testitemNameC;
	}

	public String getTestitemFt() {
		return testitemFt;
	}

	public void setTestitemFt(String testitemFt) {
		this.testitemFt = testitemFt;
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

	public String getItemNameComm() {
		return itemNameComm;
	}

	public void setItemNameComm(String itemNameComm) {
		this.itemNameComm = itemNameComm;
	}

	public Integer getCleanStatus() {
		return cleanStatus;
	}

	public void setCleanStatus(Integer cleanStatus) {
		this.cleanStatus = cleanStatus;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}
}