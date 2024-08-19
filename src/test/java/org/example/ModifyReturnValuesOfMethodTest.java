package org.example;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.WithByteman;
import org.junit.jupiter.api.Test;

@WithByteman
public class ModifyReturnValuesOfMethodTest {

    @Test
    @BMRules(rules = {
            @BMRule(
                    name = "Modify return values of method",
                    targetClass = "ModifyReturnValuesOfMethod",
                    targetMethod = "shouldReturnZero",
                    targetLocation = "ENTRY",
                    action = "return 9999")
    })
    public void modifyReturnValueTest() {
        var sample = new ModifyReturnValuesOfMethod();
        assertThat(sample.shouldReturnZero()).isNotEqualTo(0);
        assertThat(sample.shouldReturnZero()).isEqualTo(9999);
    }
}
