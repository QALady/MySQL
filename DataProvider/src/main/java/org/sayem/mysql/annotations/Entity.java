package org.sayem.mysql.annotations;

import org.sayem.mysql.enums.Schema;

import java.lang.annotation.*;

/**
 * Author: Nayeem Islam
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(Entities.class)
public @interface Entity {
    Class entity();

    Schema schema();

    int invocationCount() default 0;

    long[] ids() default {};
}
