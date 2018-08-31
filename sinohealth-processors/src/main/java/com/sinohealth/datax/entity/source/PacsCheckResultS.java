package com.sinohealth.datax.entity.source;

import com.sinohealth.datax.reflection.annotations.db_alias;

import java.util.Date;

/**
 * @author Tony
 * @date 2018/8/7
 **/
@db_alias("jj_comm_jc_result")
public class PacsCheckResultS {

    private String				vid;
    private String				cid;
    @db_alias("item_id")
    private String				itemId;
    @db_alias("field_comment")
    private String				fieldComment;
    @db_alias("field_results")
    private String				fieldResults;
    @db_alias("zcz_xx")
    private String				zczXx;
    @db_alias("zcz_sx")
    private String				zczSx;
    private String				dw;
    @db_alias("init_results")
    private String				initResults;
    @db_alias("in_factory")
    private String				inFactory;
    @db_alias("op_datetime")
    private String				opDatetime;
    private Date                yysj;

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

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    public String getFieldResults() {
        return fieldResults;
    }

    public void setFieldResults(String fieldResults) {
        this.fieldResults = fieldResults;
    }

    public String getZczXx() {
        return zczXx;
    }

    public void setZczXx(String zczXx) {
        this.zczXx = zczXx;
    }

    public String getZczSx() {
        return zczSx;
    }

    public void setZczSx(String zczSx) {
        this.zczSx = zczSx;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getInitResults() {
        return initResults;
    }

    public void setInitResults(String initResults) {
        this.initResults = initResults;
    }

    public String getInFactory() {
        return inFactory;
    }

    public void setInFactory(String inFactory) {
        this.inFactory = inFactory;
    }


    public String getOpDatetime() {
        return opDatetime;
    }

    public void setOpDatetime(String opDatetime) {
        this.opDatetime = opDatetime;
    }

    public Date getYysj() {
        return yysj;
    }

    public void setYysj(Date yysj) {
        this.yysj = yysj;
    }
}
