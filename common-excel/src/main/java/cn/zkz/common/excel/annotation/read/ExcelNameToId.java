package cn.zkz.common.excel.annotation.read;

import java.lang.annotation.*;

/**
 * @Desc 名称转ID，找不到ID则报错
 * @Author zkz
 * @Date 2021/12/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ExcelNameToId {

    /**
     * 表名
     * @return
     */
    String tableName();

    /**
     * 名称字段名
     * @return
     */
    String colName();

    /**
     * ID字段名
     * @return
     */
    String colId();

    /**
     * 过滤条件 SQL
     * TODO 可根据登录信息占位符进行过滤
     * @return
     */
    String filter();


    /**
     * ID列
     * @return
     */
    String idField();

}
