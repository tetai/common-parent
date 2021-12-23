package cn.zkz.common.excel.handler;

import cn.zkz.common.excel.LogInfo;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/21
 */
public abstract class AbstractPrepareHandler {

    private AbstractPrepareHandler nextHandler;

    public AbstractPrepareHandler(AbstractPrepareHandler nextHandler) {
        this.nextHandler = nextHandler;

    }

    public void execute(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs) {
        this.handle(clazz, dataList, errorLogs);
        while (this.nextHandler != null) {
            this.nextHandler.handle(clazz, dataList, errorLogs);
            this.nextHandler = this.nextHandler.nextHandler;
        }
    }

    public abstract void handle(Class clazz, List<Object> dataList, Map<Integer, LogInfo> errorLogs);

}
