package lotto.util;

import static lotto.config.PurchaseErrorMessage.PURCHASE_NUMERIC_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntParserTest {
    @DisplayName("String 타입 값을 Integer 값으로 변환")
    @Test
    void success() {
        // give
        String input = "123456";
        // when, then
        assertThat(IntParser.parseInt(input)).isEqualTo(123456);
    }

    @DisplayName("번호 분리 실패시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234 5", "12,3", "1a2rt", "하이", "1.0"}) // give
    void fail(String input) {
        // when, then
        assertThatThrownBy(() -> IntParser.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_NUMERIC_ERROR_MESSAGE.getMessage());
    }
}