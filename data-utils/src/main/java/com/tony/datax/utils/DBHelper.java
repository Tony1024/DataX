package com.tony.datax.utils;

import cn.hutool.core.util.StrUtil;
import com.tony.datax.reflection.Reflector;
import com.tony.datax.reflection.factory.DefaultObjectFactory;
import com.tony.datax.reflection.factory.ObjectFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tony
 * @date 2018/7/27
 **/
public class DBHelper {

    public static <T> T parseResultObj(Class<T> clazz, ResultSet rs) throws Exception {
        T obj = null;
        try {
            if (rs != null && !rs.wasNull()) {
                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();
                Reflector reflector = Reflector.forClass(clazz);
                if (rs.next()) {
                    ObjectFactory objectFactory = new DefaultObjectFactory();
                    obj = objectFactory.create(clazz);
                    for (int i = 1; i <= columnCount; i++) {
                        String columname = md.getColumnLabel(i);
                        if (StrUtil.isBlank(columname)) {
                            columname = md.getColumnName(i);
                        }
                        String propertyname = reflector.getFieldName(columname);
                        if (reflector.hasSetter(propertyname)) {
                            Object columnvalue = rs.getObject(i);
                            if (columnvalue != null) {
                                try {
                                    Class<?> fieldtype = reflector.getSetterType(propertyname);

                                    if (fieldtype.equals(Short.class) || fieldtype.equals(short.class)) {
                                        columnvalue = rs.getShort(i);
                                    } else if (fieldtype.equals(Byte.class) || fieldtype.equals(byte.class)) {
                                        columnvalue = rs.getByte(i);
                                    } else if (fieldtype.equals(Integer.class) || fieldtype.equals(int.class)) {
                                        columnvalue = rs.getInt(i);
                                    } else if (fieldtype.equals(Long.class) || fieldtype.equals(long.class)) {
                                        columnvalue = rs.getLong(i);
                                    } else if (fieldtype.equals(Float.class) || fieldtype.equals(float.class)) {
                                        columnvalue = rs.getFloat(i);
                                    } else if (fieldtype.equals(Double.class) || fieldtype.equals(double.class)) {
                                        columnvalue = rs.getDouble(i);
                                    } else if (fieldtype.equals(Boolean.class) || fieldtype.equals(boolean.class)) {
                                        columnvalue = rs.getBoolean(i);
                                    } else if (fieldtype.equals(Date.class)) {
                                        columnvalue = rs.getTimestamp(i);
                                    } else if (fieldtype.equals(String.class)) {
                                        columnvalue = rs.getString(i);
                                    }

                                    reflector.getSetInvoker(propertyname).invoke(obj, new Object[]{columnvalue});
                                } catch (Exception e) {
                                    throw new Exception("DaoHelper.parseResultObj faild,columname:" + columname, e);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("DaoHelper.parseResultObj faild", e);
        }
        return obj;
    }

    public static <T> List<T> parseResultList(Class<T> clazz, ResultSet rs) throws Exception {
        List<T> array = new ArrayList<T>();
        try {
            if (rs != null && !rs.wasNull()) {
                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();
                Reflector reflector = Reflector.forClass(clazz);
                while (rs.next()) {
                    ObjectFactory objectFactory = new DefaultObjectFactory();
                    T obj = objectFactory.create(clazz);
                    for (int i = 1; i <= columnCount; i++) {
                        String columname = md.getColumnLabel(i);
                        if (StrUtil.isBlank(columname)) {
                            columname = md.getColumnName(i);
                        }
                        String propertyname = reflector.getFieldName(columname);
                        if (reflector.hasSetter(propertyname)) {
                            Object columnvalue = rs.getObject(i);
                            if (columnvalue != null) {
                                try {
                                    Class<?> fieldtype = reflector.getSetterType(propertyname);
                                    if (fieldtype.equals(Short.class) || fieldtype.equals(short.class)) {
                                        columnvalue = rs.getShort(i);
                                    } else if (fieldtype.equals(Byte.class) || fieldtype.equals(byte.class)) {
                                        columnvalue = rs.getByte(i);
                                    } else if (fieldtype.equals(Integer.class) || fieldtype.equals(int.class)) {
                                        columnvalue = rs.getInt(i);
                                    } else if (fieldtype.equals(Long.class) || fieldtype.equals(long.class)) {
                                        columnvalue = rs.getLong(i);
                                    } else if (fieldtype.equals(Float.class) || fieldtype.equals(float.class)) {
                                        columnvalue = rs.getFloat(i);
                                    } else if (fieldtype.equals(Double.class) || fieldtype.equals(double.class)) {
                                        columnvalue = rs.getDouble(i);
                                    } else if (fieldtype.equals(Boolean.class) || fieldtype.equals(boolean.class)) {
                                        columnvalue = rs.getBoolean(i);
                                    } else if (fieldtype.equals(Date.class)) {
                                        columnvalue = rs.getTimestamp(i);
                                    } else if (fieldtype.equals(String.class)) {
                                        columnvalue = rs.getString(i);
                                    }

                                    reflector.getSetInvoker(propertyname).invoke(obj, new Object[]{columnvalue});
                                } catch (Exception e) {
                                    throw new Exception("DaoHelper.parseResultList faild,columname:" + columname, e);
                                }
                            }
                        }
                    }
                    array.add(obj);
                }
            }
        } catch (Exception e) {
            throw new Exception("DaoHelper.parseResultList faild", e);
        }
        return array;
    }


}
