package cn.zkz.common.excel.handler.impl;

import cn.zkz.common.excel.LogInfo;
import cn.zkz.common.excel.annotation.ExcelFieldIsNotEmpty;
import cn.zkz.common.excel.handler.AbstractPrepareHandler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Desc 判断是否为空
 * @Author zkz
 * @Date 2021/12/21
 */
public class CheckEmptyHandler extends AbstractPrepareHandler {

    public CheckEmptyHandler(AbstractPrepareHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        // 根据注解先查出哪些列需要判断不为空
        Field[] fields = clazz.getDeclaredFields();
        List<Field> needCheckFields = new ArrayList<>();
        for (Field f: fields) {
            if (f.getAnnotation(ExcelFieldIsNotEmpty.class) != null) {
                needCheckFields.add(f);
            }
        }
        if (needCheckFields.isEmpty()) {
            return;
        }
        needCheckFields.forEach(x -> {
            for(int i=0; i<dataList.size(); i++) {
                Object y = dataList.get(i);
                try {
                    if (y != null && y.getClass().getDeclaredField(x.getName()) != null) {
                        Field declaredField = y.getClass().getDeclaredField(x.getName());
                        declaredField.setAccessible(true);
                        Object o = declaredField.get(y);
                        if (Objects.isNull(o)) {
                            // 记录错误日志
                            if (errorLogs.containsKey(i)) {
                                errorLogs.get(i).setInfo(x.getName() + " is null").setCell(x.getName());
                            }else {
                                errorLogs.put(i, new LogInfo(x.getName(), x.getName() + " is null"));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        });

    }
}
