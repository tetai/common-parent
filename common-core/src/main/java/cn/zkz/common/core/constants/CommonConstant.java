package cn.zkz.common.core.constants;

import com.google.common.collect.ImmutableSet;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * 公共常量
 * @author: hhf
 * @date: 2021/2/24
 **/
public class CommonConstant {
    public static final String OK = "OK";
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String COMMA = ",";
    public static final String UNDER_LINE = "_";
    public static final String MINUS = "-";
    public static final String QUESTION = "?";
    public static final String PERCENTAGE = "%";
    public static final int FIRST_ELEMENT = 0;
    public static final int ZERO = 0;

    public static final String IGNORE_H5_URL_MAPPING = "/h5/api";

    /**
     * 默认的拼接字符
     */
    public static final String DEFAULT_JOIN_CHAR = ",";

    public static final class CommonCollection {
        public static final Set<String> IGNORE_URL = ImmutableSet.of("/swagger", "Excel");

        public static final Set<String> IGNORE_URL_MAPPING = ImmutableSet.of(IGNORE_H5_URL_MAPPING);

        public static Boolean contain(Set<String> ignores, String uri) {
            if (CollectionUtils.isEmpty(ignores)) {
                return false;
            }
            for (String ignoreUrl : ignores) {
                if (uri.startsWith(ignoreUrl)) {
                    return true;
                }
            }
            return false;
        }
    }
}
