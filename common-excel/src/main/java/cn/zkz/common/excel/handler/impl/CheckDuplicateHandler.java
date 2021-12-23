package cn.zkz.common.excel.handler.impl;

import cn.zkz.common.excel.LogInfo;
import cn.zkz.common.excel.handler.AbstractPrepareHandler;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/21
 */
public class CheckDuplicateHandler extends AbstractPrepareHandler {

    public CheckDuplicateHandler(AbstractPrepareHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        System.out.println("CheckDuplicateHandler");
    }
}
