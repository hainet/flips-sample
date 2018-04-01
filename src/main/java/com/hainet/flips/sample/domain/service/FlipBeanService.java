package com.hainet.flips.sample.domain.service;

import org.flips.annotation.FlipBean;
import org.springframework.stereotype.Service;

@Service
public class FlipBeanService {

    @FlipBean(with = ConcreteFlipBeanService.class)
    public String service() {
        return "-- " + this.getClass().getSimpleName() + "#service";
    }
}
