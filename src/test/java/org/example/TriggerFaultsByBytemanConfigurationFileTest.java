package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.WithByteman;
import org.junit.jupiter.api.Test;

@WithByteman
public class TriggerFaultsByBytemanConfigurationFileTest {

    @Test
    @BMScript(value = "scripts/throw.btm")
    public void triggerFaultByBytemanConfigurationFileTest() {
        var sample = new TriggerFaultsByBytemanConfigurationFile();
        assertThatThrownBy(sample::doSomething).isInstanceOf(RuntimeException.class)
                .hasMessage("BOOM");
    }
}
