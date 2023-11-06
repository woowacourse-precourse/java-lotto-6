package lotto.util;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntegerUtilTest {

    @Test
    public void 정수면_true() {
        // Given
        String input = "2000000000";

        // When
        boolean result = IntegerUtil.isInteger(input);

        // Then
        assertTrue(result);
    }

    @Test
    public void 정수아니면_false_정수범위초과() {
        // Given
        String input = "2200000000";

        // When
        boolean result = IntegerUtil.isInteger(input);

        // Then
        assertFalse(result);
    }

    @Test
    public void 정수아니면_false_숫자아닌값() {
        // Given
        String input = "hi";

        // When
        boolean result = IntegerUtil.isInteger(input);

        // Then
        assertFalse(result);
    }

    @Test
    public void 문자의_앞뒤공백제거후_정수로변환() {
        // Given
        String input = " 1000 ";

        // When
        int result = IntegerUtil.trimAndParseInt(input);

        // Then
        assertThat(result).isEqualTo(1000);
    }
}