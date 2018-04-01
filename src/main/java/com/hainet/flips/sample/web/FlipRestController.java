package com.hainet.flips.sample.web;

import com.hainet.flips.sample.domain.annotation.MyFlipOn;
import com.hainet.flips.sample.domain.service.FlipBeanService;
import org.flips.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;

@RestController
public class FlipRestController {

    // curl "localhost:8080/describe/features" -v

    // curl "localhost:8080/flip-on-environment-property" -v
    @GetMapping("flip-on-environment-property")
    @FlipOnEnvironmentProperty(
            property = "flip-on-environment-property",
            expectedValue = "true"
    )
    public String flipOnEnvironmentProperty() {
        return "-- " + this.getClass().getSimpleName() + "#flipOnEnvironmentProperty";
    }

    // curl "localhost:8080/flip-on-profiles" -v
    @GetMapping("flip-on-profiles")
    @FlipOnProfiles(activeProfiles = "prod")
    public String flipOnProfiles() {
        return "-- " + this.getClass().getSimpleName() + "#flipOnProfiles";
    }

    // curl "localhost:8080/flip-on-days-of-week" -v
    @GetMapping("flip-on-days-of-week")
    @FlipOnDaysOfWeek(daysOfWeek = {DayOfWeek.SATURDAY, DayOfWeek.SUNDAY})
    public String flipOnDaysOfWeek() {
        return "-- " + this.getClass().getSimpleName() + "#flipOnDaysOfWeek";
    }

    // curl "localhost:8080/flip-on-date-time" -v
    @GetMapping("flip-on-date-time")
    @FlipOnDateTime(cutoffDateTimeProperty = "flip-on-date-time.after")
    public String flipOnDateTime() {
        return "-- " + this.getClass().getSimpleName() + "#flipOnDateTime";
    }

    // curl "localhost:8080/flip-on-spring-expression" -v
    @GetMapping("flip-on-spring-expression")
    @FlipOnSpringExpression(expression = "T(java.lang.Math).sqrt(4) == 2")
    public String flipOnSpringExpression() {
        return "-- " + this.getClass().getSimpleName() + "#flipOnSpringExpression";
    }

    private FlipBeanService flipBeanService;

    public FlipRestController(final FlipBeanService flipBeanService) {
        this.flipBeanService = flipBeanService;
    }

    // curl "localhost:8080/flip-bean" -v
    @GetMapping("flip-bean")
    public String flipOnFlipBean() {
        return flipBeanService.service();
    }

    // curl "localhost:8080/flip-off" -v
    @GetMapping("flip-off")
    @FlipOff
    public String flipOff() {
        return "-- " + this.getClass().getSimpleName() + "#flipOff";
    }

    // curl "localhost:8080/my-flip-on" -v
    @GetMapping("my-flip-on")
    @MyFlipOn
    public String appFlipOn() {
        return "-- " + this.getClass().getSimpleName() + "#myFlipOn";
    }
}
