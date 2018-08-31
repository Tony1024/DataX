package com.sinohealth.datax.processors;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.sinohealth.datax.common.CommonData;
import com.sinohealth.datax.common.Processor;
import com.sinohealth.datax.entity.source.RegCustomerS;
import com.sinohealth.datax.entity.target.RegCustomerT;

import java.util.Date;

/**
 * @author Tony
 * @date 2018/8/7
 **/
public class RegCustomerProcessor implements Processor<RegCustomerS, RegCustomerT> {

    @Override
    public RegCustomerT dataProcess(RegCustomerS regCustomerS, RegCustomerT o, CommonData commonData) {
        RegCustomerT rc = new RegCustomerT();
        rc.setCleanDate(DateUtil.date(System.currentTimeMillis()));
        rc.setIdCard(regCustomerS.getBzSfzhm());
        if (StrUtil.isNotBlank(regCustomerS.getBzBm1())) {
            rc.setDepartment(regCustomerS.getBzBm1());
        } else {
            rc.setDepartment(regCustomerS.getBzBm2());
        }
        rc.setCompanyCode(regCustomerS.getDwdm());
        rc.setVid(regCustomerS.getVid());
        rc.setCid(regCustomerS.getCid());
        rc.setName(regCustomerS.getCustName());
        rc.setSex(regCustomerS.getCustXb());
        rc.setBirthDate(regCustomerS.getCustCsrq());
        rc.setJob(regCustomerS.getCustZy());
        rc.setJobIndustry(regCustomerS.getCustGzhy());
        rc.setBookTime(regCustomerS.getYysj());
        rc.setBookPerson(regCustomerS.getYydjr());
        rc.setBookRegTime(regCustomerS.getYydjsj());
        rc.setShopNo(regCustomerS.getJjzh());
        rc.setStatus(regCustomerS.getStatus());
        rc.setOtherRegPerson(regCustomerS.getQtdjr());
        rc.setOtherRegTime(regCustomerS.getQtdjsj());
        rc.setBodyCheckTime(regCustomerS.getTjsj());
        rc.setBodyCheckOrgTime(regCustomerS.getTjzzsj());
        rc.setMemberType(regCustomerS.getMemberType());
        rc.setPrintTime(regCustomerS.getPrintTime());
        if (rc.getBookRegTime() != null && rc.getBookRegTime().before(new Date(0))) {
            rc.setBookRegTime(new Date(0));
        }
        if (rc.getBirthDate() != null) {
            rc.setAge(DateUtil.age(rc.getBirthDate(), rc.getBookTime()));
            rc.setAgeDiscrete(rc.getAge() / 10);
            rc.setCleanStatus(0);
        } else {
            rc.setCleanStatus(1);
        }

        return rc;
    }

}
