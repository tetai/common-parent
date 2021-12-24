package cn.zkz.common.excel.annotation;

import java.lang.annotation.*;

/**
 * @Desc 头部有几行（从几行开始读数据）
 * @Author zkz
 * @Date 2021/12/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface HeadRowNumber {

    int value() default 1;

}
