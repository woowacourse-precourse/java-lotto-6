package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOrNotTest {
    @DisplayName("숫자로 변환 가능한 문자열을 올바르게 판별한다.")
    @Test
    void testIsNumber_NumberString() {
        String numberString = "123";

        boolean isNumber = NumberOrNot.isNumber(numberString);

        assertThat(isNumber).isTrue();
    }

    @DisplayName("숫자로 변환 불가능한 문자열을 올바르게 판별한다.")
    @Test
    void testIsNumber_NonNumberString() {
        String nonNumberString = "abc"; // 숫자로 변환할 수 없는 문자열

        boolean isNumber = NumberOrNot.isNumber(nonNumberString);

        assertThat(isNumber).isFalse();
    }
}