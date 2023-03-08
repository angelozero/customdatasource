package com.angelozero.customdatasource.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

@Slf4j
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    private final Pattern READER_PATTERN;
    private final Pattern WRITER_PATTERN;

    public DataSourceAspect(@Value("${spring.datasource.reader.pattern}") String readerPattern,
                            @Value("${spring.datasource.writer.pattern}") String writerPattern) {
        READER_PATTERN = Pattern.compile(getRegex(readerPattern));
        WRITER_PATTERN = Pattern.compile(getRegex(writerPattern));
    }

    private String getRegex(String str) {
        return str.replaceAll("\\*", ".*")
                .replaceAll(" ", "")
                .replaceAll(",", "|");
    }

    @Around("within(@com.angelozero.customdatasource.config.DataSourceAnnotation *)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            DynamicDataSourceContextHolder.clearDataSourceType();

            Method method = ((MethodSignature) point.getSignature()).getMethod();

            if (READER_PATTERN.matcher(method.getName()).matches()) {
                DynamicDataSourceContextHolder.setDataSourceType(DataSourceTypeEnum.READER.name());
            } else {
                DynamicDataSourceContextHolder.setDataSourceType(DataSourceTypeEnum.WRITER.name());
            }

            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

}
