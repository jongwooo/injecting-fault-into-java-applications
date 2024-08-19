package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncreaseMethodLatency {

    private final Logger logger = LoggerFactory.getLogger(IncreaseMethodLatency.class);

    public long executionTimeMillis() {
        final long start = System.currentTimeMillis();
        targetMethod();
        final long end = System.currentTimeMillis();
        return end - start;
    }

    private void targetMethod() {
        logger.info("Hello World!");
    }
}
