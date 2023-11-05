package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @DisplayName("정수 형태의 문자열이 제대로 변환되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"123,123", "-123,-123", "2147483647,2147483647", "-2147483648,-2147483648"})
    void checkParseIntOrThrow(String numericString, int answer) {
        assertThat(Parser.parseIntOrThrow(numericString)).isEqualTo(answer);
    }

    @DisplayName("정수형태가 아닌 문자열을 입력하면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"ABC", "12L", "13.5"})
    void checkParseIntOrThrowWithNoNumeric(String numericString) {
        assertThatThrownBy(() -> Parser.parseIntOrThrow(numericString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Integer 범위를 벗어난 문자열을 입력하면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483649", "999999999999999"})
    void checkParseIntOrThrowWithWrongRange(String numericString) {
        assertThatThrownBy(() -> Parser.parseIntOrThrow(numericString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
