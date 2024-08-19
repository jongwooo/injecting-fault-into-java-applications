package org.example;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.WithByteman;
import org.junit.jupiter.api.Test;

@WithByteman
public class IncreaseMethodLatencyTest {

    @Test
    @BMRules(rules = {
            @BMRule(
                    name = "Increase method latency",
                    targetClass = "IncreaseMethodLatency",
                    targetMethod = "targetMethod",
                    targetLocation = "ENTRY",
                    action = "Thread.sleep(5000)"),
    })
    public void increaseMethodLatencyTest() {
        var sample = new IncreaseMethodLatency();
        assertThat(sample.executionTimeMillis()).isGreaterThanOrEqualTo(5_000);
    }
}
