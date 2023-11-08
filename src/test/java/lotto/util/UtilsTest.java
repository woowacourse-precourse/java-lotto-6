package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Map;

class UtilsTest {

    @Test
    void testRound() {
        Map<Double, String> testCases = Map.of(
                3.14, "3.1",
                5.67173, "5.7",
                3.05, "3.1",
                3.04, "3.0"
        );

        testCases.forEach((testCase, expected) -> {
            assertThat(Utils.round(testCase)).isEqualTo(expected);
        });
    }
}