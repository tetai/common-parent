package cn.zkz.common.core.utils;


import java.io.UnsupportedEncodingException;
import java.util.Base64;



public class Base64Util {

    public static String encode(String str){
        try {
            return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String decode(String str){
        try {
            return new String(Base64.getDecoder().decode(str),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
