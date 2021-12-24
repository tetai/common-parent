package cn.zkz.common.excel.utils;


import cn.zkz.common.excel.annotation.HeadRowNumber;
import cn.zkz.common.excel.handler.AbstractPrepareHandler;
import cn.zkz.common.excel.handler.impl.CheckDuplicateHandler;
import cn.zkz.common.excel.handler.impl.CheckEmptyHandler;
import cn.zkz.common.excel.model.LogInfo;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/21
 */
@Slf4j
public class ExcelUtil<T> {


    public Result<List<T>> read(InputStream inputStream, Class clazz) {
        log.info("start------------");
        List<T> res = new ArrayList<>();
        EasyExcel.read(inputStream, clazz, new PageReadListener<T>(dataList -> {
            res.addAll(dataList);

        })).sheet().headRowNumber(getHeadRowNum(clazz)).doRead();
        // 3 判断是否重复
        AbstractPrepareHandler checkDuplicateHandler = new CheckDuplicateHandler(null);
        // 2 判断是否为空
        AbstractPrepareHandler handler = new CheckEmptyHandler(checkDuplicateHandler);
        Map<Integer, LogInfo> errorLogs = new HashMap<>();
        handler.execute(clazz, (List<Object>) res, errorLogs);

        return Result.success(res);
    }

    public int getHeadRowNum(Class<? extends Class> clazz) {
        HeadRowNumber annotation = clazz.getAnnotation(HeadRowNumber.class);
        return annotation == null ? 1 : annotation.value();
    }

}
