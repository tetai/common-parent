package cn.zkz.common.core.utils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FileUtils {

    public static String parseFileExtInfo(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return null;
        } else {
            return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        }
    }
}
