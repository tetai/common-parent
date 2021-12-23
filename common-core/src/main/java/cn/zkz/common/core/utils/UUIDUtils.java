package cn.zkz.common.core.utils;

import java.util.UUID;


public class UUIDUtils {

    public static final String UUID_SPLIT = "-";
    public static final Integer UUID_LENGTH = 32;
    public static final Integer UUID_WITHOUT_SPLIT_LENGTH = 28;

    public static String getUUID() {
        return getUUID(32);
    }

    /**
     * 获取uuid
     * @param length 长度
     * @return
     */
    public static String getUUID(int length) {
        if (length <= 0){
            return "";
        }
        String uuid = UUID.randomUUID().toString();
        if (length >= UUID_LENGTH){
            return uuid;
        }
        return uuid.substring(0,length);
    }

    private static String getUUIDWithoutSplit() {
        return getUUIDWithoutSplit(UUID_LENGTH);
    }

    /**
     * 获取没有分隔符的uuid
     * @param length 长度
     * @return
     */
    public static String getUUIDWithoutSplit(int length){
        if (length <= 0){
            return "";
        }
        String uuid = getUUID(length).replaceAll(UUID_SPLIT,"");
        if (length >= UUID_WITHOUT_SPLIT_LENGTH){
            return uuid;
        }
        return uuid.substring(0,length);
    }


    public static void main(String[] args) {
        System.out.println(getUUID());
        System.out.println(getUUID(8));
        System.out.println(getUUIDWithoutSplit());
    }
}
