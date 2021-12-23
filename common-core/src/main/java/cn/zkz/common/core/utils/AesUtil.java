package cn.zkz.common.core.utils;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;


@Slf4j
public class AesUtil {

    /**
     * AES解密
     * @param content 加密字符串
     * @param key 解密key
     * @param iv 向量
     * @return 解密后的字符串
     */
    public static String decrypt(String content, String key, String iv) {
        try {
            byte[] raw = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ips);
            byte[] encrypted = new BASE64Decoder().decodeBuffer(content);
            try {
                byte[] original = cipher.doFinal(encrypted);
                return new String(original);
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new RuntimeException("AES解密失败");
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new RuntimeException("AES解密失败");
        }
    }

}
