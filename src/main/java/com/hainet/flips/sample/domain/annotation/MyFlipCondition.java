package com.hainet.flips.sample.domain.annotation;

import org.flips.condition.FlipCondition;
import org.flips.model.FeatureContext;
import org.flips.model.FlipAnnotationAttributes;
import org.springframework.stereotype.Component;

@Component
public class MyFlipCondition implements FlipCondition {

    @Override
    public boolean evaluateCondition(
            final FeatureContext featureContext,
            final FlipAnnotationAttributes flipAnnotationAttributes) {
        System.out.println(featureContext);
        System.out.println(flipAnnotationAttributes);

        return true;
    }
}
