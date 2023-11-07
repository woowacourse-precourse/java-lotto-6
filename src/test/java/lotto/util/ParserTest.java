package lotto.util;

import lotto.config.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC_STRING.message());
    }

    @DisplayName("Integer 범위를 벗어난 문자열을 입력하면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483649", "999999999999999"})
    void checkParseIntOrThrowWithWrongRange(String numericString) {
        assertThatThrownBy(() -> Parser.parseIntOrThrow(numericString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_INTEGER_RANGE.message());
    }

    @DisplayName("정수 리스트 형태의 문자열이 제대로 변환되는지 확인")
    @ParameterizedTest
    @MethodSource("parseIntListResult")
    void checkParseIntListOrThrow(String numericString, List<Integer> answer) {
        assertThat(Parser.parseIntListOrThrow(numericString))
                .isEqualTo(answer);
    }

    @DisplayName("각 숫자가 정수 형태가 아니면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "12.5,15.2,-21.6", "12L,10F,5A"})
    void checkParseIntListOrThrowWithNoNumeric(String numericString) {
        assertThatThrownBy(() -> Parser.parseIntListOrThrow(numericString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC_STRING.message());
    }

    @DisplayName("각 숫자가 Integer 범위를 벗어나면 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2147483648,-2147483649","99999999999999,999999999999999"})
    void checkParseIntListOrThrowWithWrongRange(String numericString) {
        assertThatThrownBy(() -> Parser.parseIntListOrThrow(numericString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_INTEGER_RANGE.message());
    }

    static Stream<Arguments> parseIntListResult() {
        return Stream.of(
                Arguments.of("1,2,3,4", List.of(1, 2, 3, 4)),
                Arguments.of("1", List.of(1)),
                Arguments.of("2147483647,-2147483648", List.of(2147483647, -2147483648))
        );
    }
}
