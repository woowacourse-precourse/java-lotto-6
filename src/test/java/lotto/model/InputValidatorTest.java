package lotto.model;

import static lotto.model.enums.ErrorMessage.NOT_CORRECT_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.OUT_OF_RANGE_NUMBER_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("notIntegerParameter")
    @DisplayName("정수가 아닐 시 예외 발생")
    void notIntegerNumbersInput(String testName, List<String> input) {
        assertThatThrownBy(() -> inputValidator.validateInput(input))
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

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("outOfRangeParameter")
    @DisplayName("범위 밖의 숫자 예외 발생")
    void outOfRangeNumbersInput(String testName, List<String> input) {
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }

    private static Stream<Arguments> outOfRangeParameter() {
        return Stream.of(
                // 최댓값 초과 시 오류 발생
                Arguments.of("Null 예외 발생", List.of("1", "2", "3", "4", "46")),

                // 최솟값 미만 시 오류 발생
                Arguments.of("소수 입력 예외 발생", List.of("1", "2", "3", "4", "0"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0.5", "안녕", "5+1"})
    @DisplayName("정수가 아닐 시 예외 발생")
    void notIntegerNumberInput(String input) {
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_INPUT_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-10", "0", "46", "100"})
    @DisplayName("범위 밖의 숫자 예외 발생")
    void outOfRangeNumberInput(String input) {
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
    }
}