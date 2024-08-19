package org.example;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.WithByteman;
import org.junit.jupiter.api.Test;

@WithByteman
public class TriggerGarbageCollectionTest {

    @Test
    @BMRules(rules = {
            @BMRule(
                    name = "Trigger garbage collection",
                    targetClass = "TriggerGarbageCollection",
                    targetMethod = "targetMethod",
                    targetLocation = "ENTRY",
                    action = "System.gc();")
    })
    public void triggerGarbageCollectionTest() throws Exception {
        var sample = new TriggerGarbageCollection();
        assertThat(sample.shouldIncreaseMemoryUsage()).isFalse();
    }
}
