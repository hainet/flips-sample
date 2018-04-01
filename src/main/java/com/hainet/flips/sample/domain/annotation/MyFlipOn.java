package com.hainet.flips.sample.domain.annotation;

import org.flips.annotation.FlipOnOff;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@FlipOnOff(MyFlipCondition.class)
public @interface MyFlipOn {
}
