package cn.zkz.common.core.utils;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class LocalDateTimeUtil {

    /**
     * Date转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime toLocalDateTime(Date date){
        if(date == null){
            return null;
        }
        return DateUtil.toLocalDateTime((date));
    }

    /**
     * LocalDateTime转Date
     * @param localDateTime
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime){
        if(localDateTime == null){
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }
}
