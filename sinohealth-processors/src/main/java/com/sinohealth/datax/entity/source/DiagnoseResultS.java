package com.sinohealth.datax.entity.source;

import com.sinohealth.datax.reflection.annotations.db_alias;

import java.util.Date;

/**
 * <p>
 * 诊断内容
 * </p>
 *
 * @author Tony
 * @date 2018/8/7
 */
@db_alias("jj_cust_zdnr_result")
public class DiagnoseResultS {

	/**
	 * 体检编号
	 */
	private String						vid;
	/**
	 * 项目编号
	 */
	@db_alias("item_id")
	private String						itemId;
	/**
	 * 项目描述
	 */
	@db_alias("item_ms")
	private String						itemMs;
	/**
	 * 项目描述贮备
	 */
	@db_alias("item_ms_zb")
	private String						itemMsZb;
	/**
	 * 诊断内容
	 */
	@db_alias("zd_nr")
	private String						zdNr;
	/**
	 * 模板内容
	 */
	private String						mbnr;
	/**
	 * 是否疾病
	 */
	private String						sfjb;
	/**
	 * 建议标题
	 */
	private String						jybt;
	/**
	 * 医学解释
	 */
	private String						yxjs;
	/**
	 * 原因后果
	 */
	private String						yyhg;
	/**
	 * 医学建议
	 */
	private String						yxjy;
	/**
	 * 登记时间
	 */
	private Date djsj;
	/**
	 * 异常部位
	 */
	private String						ycbw;
	/**
	 * 地区编码
	 */
	@db_alias("in_factory")
	private String						inFactory;
	/**
	 * 操作医生
	 */
	private String						czys;
	/**
	 * 结果
	 */
	private String						results;
	/**
	 * 范围
	 */
	private String						fw;
	@db_alias("tdbg_bt")
	private String						tdbgBt;
	@db_alias("jb_bm_mc")
	private String						jbBmMc;
    private Date                        yysj;

	public DiagnoseResultS() {
	}

	public DiagnoseResultS(String vid) {
		this.vid = vid;
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

	public String getItemMs() {
		return itemMs;
	}

	public void setItemMs(String itemMs) {
		this.itemMs = itemMs;
	}

	public String getItemMsZb() {
		return itemMsZb;
	}

	public void setItemMsZb(String itemMsZb) {
		this.itemMsZb = itemMsZb;
	}

	public String getZdNr() {
		return zdNr;
	}

	public void setZdNr(String zdNr) {
		this.zdNr = zdNr;
	}

	public String getMbnr() {
		return mbnr;
	}

	public void setMbnr(String mbnr) {
		this.mbnr = mbnr;
	}

	public String getSfjb() {
		return sfjb;
	}

	public void setSfjb(String sfjb) {
		this.sfjb = sfjb;
	}

	public String getJybt() {
		return jybt;
	}

	public void setJybt(String jybt) {
		this.jybt = jybt;
	}

	public String getYxjs() {
		return yxjs;
	}

	public void setYxjs(String yxjs) {
		this.yxjs = yxjs;
	}

	public String getYyhg() {
		return yyhg;
	}

	public void setYyhg(String yyhg) {
		this.yyhg = yyhg;
	}

	public String getYxjy() {
		return yxjy;
	}

	public void setYxjy(String yxjy) {
		this.yxjy = yxjy;
	}

	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}

	public String getYcbw() {
		return ycbw;
	}

	public void setYcbw(String ycbw) {
		this.ycbw = ycbw;
	}

	public String getInFactory() {
		return inFactory;
	}

	public void setInFactory(String inFactory) {
		this.inFactory = inFactory;
	}

	public String getCzys() {
		return czys;
	}

	public void setCzys(String czys) {
		this.czys = czys;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getFw() {
		return fw;
	}

	public void setFw(String fw) {
		this.fw = fw;
	}

	public String getTdbgBt() {
		return tdbgBt;
	}

	public void setTdbgBt(String tdbgBt) {
		this.tdbgBt = tdbgBt;
	}

	public String getJbBmMc() {
		return jbBmMc;
	}

	public void setJbBmMc(String jbBmMc) {
		this.jbBmMc = jbBmMc;
	}

	public Date getYysj() {
		return yysj;
	}

	public void setYysj(Date yysj) {
		this.yysj = yysj;
	}
}
