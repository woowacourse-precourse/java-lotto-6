package lotto.model;

import static lotto.model.enums.ErrorMessage.NOT_CORRECT_INPUT_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
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
    @DisplayName("로또 넘버 숫자 아닐 경우 예외 발생")
    void notIntegerNumbersInputTest(String testName, List<String> input) {
        assertThatThrownBy(() -> StringToIntegerConvertor.stringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_CORRECT_INPUT_MESSAGE.getMessage());
    }

    private static Stream<Arguments> notIntegerParameter() {
        return Stream.of(
                // null, 공백 입력 시 예외
                Arguments.of("Null", List.of("1", "2", "3", "4", "")),
                Arguments.of("공백", List.of("1", "2", "3", "4", " ")),

                // 정수가 아닌 값 입력 시 예외
                Arguments.of("소수", List.of("1", "2", "3", "4", "0.5")),
                Arguments.of("문자", List.of("1", "2", "3", "4", "안녕")),
                Arguments.of("특수", List.of("1", "2", "3", "4", "5 + 1"))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("IntegerParameter")
    @DisplayName("로또 넘버 숫자일 경우 예외 발생 X")
    void integerNumbersInputTest(String testName, List<String> input) {
        assertThatCode(() -> StringToIntegerConvertor.stringToInteger(input))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> IntegerParameter() {
        return Stream.of(
                Arguments.of("숫자 리스트1", List.of("1", "2", "3", "4", "5", "6")),
                Arguments.of("숫자 리스트2", List.of("11", "12", "13", "14", "15", "16"))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"", " ", "0.5", "안녕", "5+1"})
    @DisplayName("보너스 넘버 정수가 아닐 시 예외 발생")
    void notIntegerBonusNumberInputTest(String input) {
        assertThatThrownBy(() -> StringToIntegerConvertor.stringToInteger(input))
                .isInstanceOf(NotIntegerException.class);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("보너스 넘버 정수일 경우 예외 발생X")
    void IntegerBonusNumberInputTest(String input) {
        assertThatCode(() -> StringToIntegerConvertor.stringToInteger(input))
                .doesNotThrowAnyException();
    }
}