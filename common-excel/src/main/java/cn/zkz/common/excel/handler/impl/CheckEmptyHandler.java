package cn.zkz.common.excel.handler.impl;


import cn.zkz.common.excel.annotation.ExcelFieldIsNotEmpty;
import cn.zkz.common.excel.handler.AbstractPrepareHandler;
import cn.zkz.common.excel.model.LogInfo;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Desc 判断是否为空
 * @Author zkz
 * @Date 2021/12/21
 */
@Slf4j
public class CheckEmptyHandler extends AbstractPrepareHandler {

    public CheckEmptyHandler(AbstractPrepareHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        // 根据注解先查出哪些列需要判断不为空
        List<Field> needCheckFields = getFieldsByAnnotation(clazz, ExcelFieldIsNotEmpty.class);
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
                    log.error("判断是否为空异常,err={}", e);
                    throw new RuntimeException("未知异常");
                }
            };
        });

    }
}
