package cn.zkz.common.excel.handler.impl;


import cn.zkz.common.excel.handler.AbstractPrepareHandler;
import cn.zkz.common.excel.model.LogInfo;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/21
 */
public class MappingDataHandler extends AbstractPrepareHandler {

    public MappingDataHandler(AbstractPrepareHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        System.out.println("MappingDataHandler");
    }
}
