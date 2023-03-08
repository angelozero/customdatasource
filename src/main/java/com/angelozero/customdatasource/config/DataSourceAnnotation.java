package com.angelozero.customdatasource.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceAnnotation {
    DataSourceTypeEnum value() default DataSourceTypeEnum.WRITER;
}
