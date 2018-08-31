package com.sinohealth.datax.entity.common;

import com.sinohealth.datax.reflection.annotations.db_alias;

/**
 * @author Tony
 * @date 2018/8/7
 **/
public class BasCheckItem {

    private Integer id;
    @db_alias("field_comment")
    private String fieldComment;
    @db_alias("field_comm")
    private String fieldComm;
    @db_alias("clean_status")
    private Integer cleanStatus;
    @db_alias("del_flag")
    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    public String getFieldComm() {
        return fieldComm;
    }

    public void setFieldComm(String fieldComm) {
        this.fieldComm = fieldComm;
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
}
