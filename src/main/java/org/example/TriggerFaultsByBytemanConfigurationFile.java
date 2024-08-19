package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriggerFaultsByBytemanConfigurationFile {

    private final Logger logger = LoggerFactory.getLogger(TriggerFaultsByBytemanConfigurationFile.class);

    public void doSomething() {
        logger.info("doSomething() called.");
        targetMethod();
        logger.info("doSomething() finished.");
    }

    private void targetMethod() {
        logger.info("targetMethod() called.");
        logger.info("targetMethod() ended.");
    }
}
