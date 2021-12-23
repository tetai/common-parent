package cn.zkz.common.excel.annotation;

import java.lang.annotation.*;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ExcelFieldIsNotEmpty {

}
