package cn.zkz.common.excel.annotation;

import java.lang.annotation.*;

/**
 * @Desc 该列是否可重复
 * @Author zkz
 * @Date 2021/12/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ExcelFieldIsNotDuplicate {
}
