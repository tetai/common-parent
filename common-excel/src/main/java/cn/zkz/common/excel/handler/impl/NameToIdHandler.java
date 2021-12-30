package cn.zkz.common.excel.handler.impl;



import cn.zkz.common.excel.handler.AbstractPrepareHandler;
import cn.zkz.common.excel.model.LogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.*;

/**
 * @Desc 名称转ID
 * @Author zkz
 * @Date 2021/12/21
 */
@Slf4j
public class NameToIdHandler extends AbstractPrepareHandler {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public NameToIdHandler(AbstractPrepareHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        Long start = System.currentTimeMillis();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from import_test;");

        System.out.println(maps.size());

        Long time = System.currentTimeMillis() - start;
        log.info("end NameToIdHandler----------time={}", time);
    }

    private void addDuplicateData(Integer rowNum, String name, Map<Integer, LogInfo> errorLogs) {
        if (errorLogs.containsKey(rowNum)) {
            errorLogs.get(rowNum).setInfo(name + " is duplicate").setCell(name);
        }else {
            errorLogs.put(rowNum, new LogInfo(name, name + " is duplicate"));
        }
    }
}
