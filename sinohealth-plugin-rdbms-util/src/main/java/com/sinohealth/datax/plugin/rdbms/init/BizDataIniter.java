package com.sinohealth.datax.plugin.rdbms.init;

import com.alibaba.datax.plugin.rdbms.util.DBUtil;
import com.alibaba.datax.plugin.rdbms.util.DataBaseType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sinohealth.datax.entity.common.*;
import com.sinohealth.datax.utils.DBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Tony
 * @date 2018/7/27
 **/
public class BizDataIniter {

    private static final Logger LOG = LoggerFactory.getLogger(BizDataIniter.class);

    private static final String	PREFIX	= "~";

    private DataBaseType dataBaseType;
    private String url;
    private String user;
    private String passwd;

    public BizDataIniter(DataBaseType dataBaseType, String url, String user, String passwd) {
        this.dataBaseType = dataBaseType;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public Map<String, BasTestItem> findBasTestItemMap() {
        Map<String, BasTestItem> basTestItemMap = Maps.newHashMap();
        String sql = "select * from bas_test_item where clean_status=0 and del_flag=0";
        Connection connection = DBUtil.getConnection(this.dataBaseType, this.url, this.user, this.passwd);
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            List<BasTestItem> basTestItemList = DBHelper.parseResultList(BasTestItem.class, rs);
            connection.commit();
            for (BasTestItem item : basTestItemList) {
                basTestItemMap.put(item.getTestitemFt() + PREFIX + item.getTestitemNameC(), item);
            }

            return basTestItemMap;
        } catch (Exception e) {
            LOG.error("findBasTestItemMap occur error!!", e);
            e.printStackTrace();
        } finally {
            DBUtil.closeDBResources(preparedStatement, connection);
        }

        return basTestItemMap;
    }

    public Map<String, String> findBasTestUnitMap() {
        Map<String, String> basTestItemUnitMap = Maps.newHashMap();
        String sql = "select * from bas_test_item_unit";
        Connection connection = DBUtil.getConnection(this.dataBaseType, this.url, this.user, this.passwd);
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            List<BasTestItemUnit> basTestItemUnitList = DBHelper.parseResultList(BasTestItemUnit.class, rs);
            connection.commit();
            for (BasTestItemUnit unitItem : basTestItemUnitList) {
                basTestItemUnitMap.put(unitItem.getUnit(), unitItem.getUnitComm());
            }

            return basTestItemUnitMap;
        } catch (Exception e) {
            LOG.error("findBasTestUnitMap occur error!!", e);
            e.printStackTrace();
        } finally {
            DBUtil.closeDBResources(preparedStatement, connection);
        }

        return basTestItemUnitMap;
    }

    public Map<String, List<BasTestResultDiscrete>> findTestResultDiscreteMap() {
        Map<String, List<BasTestResultDiscrete>> map = Maps.newHashMap();
        String sql = "select * from bas_test_result_discrete";
        Connection connection = DBUtil.getConnection(this.dataBaseType, this.url, this.user, this.passwd);
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            List<BasTestResultDiscrete> basTestResultDiscreteList = DBHelper.parseResultList(BasTestResultDiscrete.class, rs);
            connection.commit();
            for (BasTestResultDiscrete item : basTestResultDiscreteList) {
                String itemNameComm = item.getItemNameComm();
                List<BasTestResultDiscrete> innerItems = Lists.newArrayList();
                if (map.get(item.getItemNameComm()) != null) {
                    innerItems = map.get(itemNameComm);
                }
                innerItems.add(item);
                map.put(itemNameComm, innerItems);
            }

            return map;
        } catch (Exception e) {
            LOG.error("findTestResultDiscreteMap occur error!!", e);
            e.printStackTrace();
        } finally {
            DBUtil.closeDBResources(preparedStatement, connection);
        }

        return map;
    }

    public Map<String, BasCheckItem> findCheckItemList() {
        Map<String, BasCheckItem> checkItemMap = Maps.newHashMap();
        String sql = "select * from bas_check_item where clean_status = 0 and del_flag = 0";
        Connection connection = DBUtil.getConnection(this.dataBaseType, this.url, this.user, this.passwd);
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            List<BasCheckItem> basCheckItemList = DBHelper.parseResultList(BasCheckItem.class, rs);
            connection.commit();
            for (BasCheckItem item : basCheckItemList) {
                checkItemMap.put(item.getFieldComm(), item);
            }

            return checkItemMap;
        } catch (Exception e) {
            LOG.error("findBasTestItemMap occur error!!", e);
            e.printStackTrace();
        } finally {
            DBUtil.closeDBResources(preparedStatement, connection);
        }

        return checkItemMap;
    }

    public List<BasCheckItemInit> findCheckItemInit() {
        List<BasCheckItemInit> basCheckItemList = new ArrayList<BasCheckItemInit>();
        String sql = "select id,init_result,init_result_comm from bas_check_item_init where init_result is not null and init_result_comm is not null";
        Connection connection = DBUtil.getConnection(this.dataBaseType, this.url, this.user, this.passwd);
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            basCheckItemList = DBHelper.parseResultList(BasCheckItemInit.class, rs);
            connection.commit();

            return basCheckItemList;
        } catch (Exception e) {
            LOG.error("findBasTestItemMap occur error!!", e);
            e.printStackTrace();
        } finally {
            DBUtil.closeDBResources(preparedStatement, connection);
        }

        return basCheckItemList;
    }

    public Map<String, BasDiagnoseItem> findBasDiagnoseItemList() {
        Map<String, BasDiagnoseItem> basDiagnoseItemMap = Maps.newHashMap();
        String sql = "select * from bas_diagnose_item where clean_status=0 and del_flag=0";
        Connection connection = DBUtil.getConnection(this.dataBaseType, this.url, this.user, this.passwd);
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            List<BasDiagnoseItem> basDiagnoseItemList = DBHelper.parseResultList(BasDiagnoseItem.class, rs);
            connection.commit();
            for (BasDiagnoseItem item : basDiagnoseItemList) {
                basDiagnoseItemMap.put(item.getDiagnose(), item);
            }

            return basDiagnoseItemMap;
        } catch (Exception e) {
            LOG.error("findBasTestItemMap occur error!!", e);
            e.printStackTrace();
        } finally {
            DBUtil.closeDBResources(preparedStatement, connection);
        }

        return basDiagnoseItemMap;
    }

}
