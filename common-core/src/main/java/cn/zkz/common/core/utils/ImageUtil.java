package cn.zkz.common.core.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc 图片处理
 * @Author zkz
 * @Date 2021/12/13
 */
public class ImageUtil {

    /**
     * 生成缩略图
     * @param width
     * @param height
     */
    public static ByteArrayOutputStream thumbnail(int width, int height, InputStream inputStream) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(inputStream).size(width, height).toOutputStream(outputStream);
       return outputStream;

    }
}
