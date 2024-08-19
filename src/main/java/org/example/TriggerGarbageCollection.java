package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriggerGarbageCollection {

    private final Logger logger = LoggerFactory.getLogger(TriggerGarbageCollection.class);

    public boolean shouldIncreaseMemoryUsage() throws Exception {
        for (int i = 0; i < 1_000; i++) {
            new Object();
        }
        final long memoryUsageBeforeTargetMethod = Runtime.getRuntime()
                .totalMemory() - Runtime.getRuntime()
                .freeMemory();
        targetMethod();
        Thread.sleep(1_000);
        final long memoryUsageAfterTargetMethod = Runtime.getRuntime()
                .totalMemory() - Runtime.getRuntime()
                .freeMemory();
        return memoryUsageBeforeTargetMethod < memoryUsageAfterTargetMethod;
    }

    private void targetMethod() {
        logger.info("targetMethod() is called.");
    }
}
