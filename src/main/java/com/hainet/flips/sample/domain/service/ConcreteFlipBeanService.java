package com.hainet.flips.sample.domain.service;

import org.flips.annotation.FlipOnProfiles;
import org.springframework.stereotype.Service;

@Service
public class ConcreteFlipBeanService extends FlipBeanService {

    @Override
    @FlipOnProfiles(activeProfiles = "prod")
    public String service() {
        return "-- " + this.getClass().getSimpleName() + "#service";
    }
}
