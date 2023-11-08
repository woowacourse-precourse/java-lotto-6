package lotto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    @DisplayName("문자열이 숫자로만 이루어져 있지 않을 때")
    @Test
    void containOnlyDigitTest() {
        assertThat(Validator.containOnlyDigitTest("asd698?#23f")).isFalse();
    }

    @DisplayName("문자열이 오직 숫자로만 이루어져 있을 때")
    @Test
    void contianOnlyDigitTrueTest() {
        assertThat(Validator.containOnlyDigitTest("8000")).isTrue();
    }

    @Test
    void isValidSizeTest() {
    }
}