package lotto.model;

import static lotto.model.enums.ErrorMessage.NOT_CORRECT_INPUT_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.exceptions.NotIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringToIntegerConvertorTest {
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("notIntegerParameter")
    @DisplayName("정수가 아닐 시 예외 발생")
    void notIntegerNumbersInput(String testName, List<String> input) {
        assertThatThrownBy(() -> StringToIntegerConvertor.stringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_CORRECT_INPUT_MESSAGE.getMessage());
    }

    private static Stream<Arguments> notIntegerParameter() {
        return Stream.of(
                // null, 공백 입력 시 예외
                Arguments.of("Null 예외 발생", List.of("1", "2", "3", "4", "")),
                Arguments.of("공백 예외 발생", List.of("1", "2", "3", "4", " ")),

                // 정수가 아닌 값 입력 시 예외
                Arguments.of("소수 입력 예외 발생", List.of("1", "2", "3", "4", "0.5")),
                Arguments.of("문자 입력 예외 발생", List.of("1", "2", "3", "4", "안녕")),
                Arguments.of("특수 문자 입력 예외 발생", List.of("1", "2", "3", "4", "5 + 1"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0.5", "안녕", "5+1"})
    @DisplayName("정수가 아닐 시 예외 발생")
    void notIntegerNumberInput(String input) {
        assertThatThrownBy(() -> StringToIntegerConvertor.stringToInteger(input))
                .isInstanceOf(NotIntegerException.class);
    }
}