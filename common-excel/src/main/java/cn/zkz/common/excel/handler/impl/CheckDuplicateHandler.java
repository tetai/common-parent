package cn.zkz.common.excel.handler.impl;


import cn.zkz.common.excel.annotation.read.ExcelFieldIsNotDuplicate;
import cn.zkz.common.excel.handler.AbstractPrepareHandler;
import cn.zkz.common.excel.model.LogInfo;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Desc 判断是否重复
 * @Author zkz
 * @Date 2021/12/21
 */
@Slf4j
public class CheckDuplicateHandler extends AbstractPrepareHandler {

    public CheckDuplicateHandler(AbstractPrepareHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        log.info("start CheckDuplicateHandler---------------");
        Long start = System.currentTimeMillis();
        // 根据注解先查出哪些列需要判断不为空
        List<Field> needCheckFields = getFieldsByAnnotation(clazz, ExcelFieldIsNotDuplicate.class);
        if (needCheckFields.isEmpty()) {
            return;
        }
        needCheckFields.forEach(x -> {
            Map<Object, Integer> duplicateMap = new HashMap<>();
            Set<Object> set = new HashSet<>();
            for(int i=0; i<dataList.size(); i++) {
                Object y = dataList.get(i);
                try {
                    if (y != null && y.getClass().getDeclaredField(x.getName()) != null) {
                        Field declaredField = y.getClass().getDeclaredField(x.getName());
                        declaredField.setAccessible(true);

                        Object o = declaredField.get(y);
                        if (duplicateMap.containsKey(o)) {
                            // 出现重复
                            addDuplicateData(i, x.getName(), errorLogs);
                            if (!set.contains(o)) {
                                addDuplicateData(duplicateMap.get(o), x.getName(), errorLogs);
                                set.add(o);
                            }
                        }else {
                            duplicateMap.put(o, i);
                        }
                    }
                } catch (Exception e) {
                    log.error("判断是否为空异常,err={}", e);
                    throw new RuntimeException("未知异常");
                }
            };
        });

        Long time = System.currentTimeMillis() - start;
        log.info("end CheckDuplicateHandler----------time={}", time);
    }

    private void addDuplicateData(Integer rowNum, String name, Map<Integer, LogInfo> errorLogs) {
        if (errorLogs.containsKey(rowNum)) {
            errorLogs.get(rowNum).setInfo(name + " is duplicate").setCell(name);
        }else {
            errorLogs.put(rowNum, new LogInfo(name, name + " is duplicate"));
        }
    }
}
