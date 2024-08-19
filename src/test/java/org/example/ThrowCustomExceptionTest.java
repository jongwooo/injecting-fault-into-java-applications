package org.example;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.WithByteman;
import org.junit.jupiter.api.Test;

@WithByteman
public class ThrowCustomExceptionTest {

    @Test
    @BMRules(rules = {
            @BMRule(
                    name = "Throw custom exceptions",
                    targetClass = "ThrowCustomException",
                    targetMethod = "targetMethod",
                    targetLocation = "ENTRY",
                    action = "throw new RuntimeException(\"BOOM\")")
    })
    public void throwCustomExceptionTest() {
        var sample = new ThrowCustomException();
        assertThatThrownBy(sample::doSomething).isInstanceOf(RuntimeException.class)
                .hasMessage("BOOM");
    }
}
