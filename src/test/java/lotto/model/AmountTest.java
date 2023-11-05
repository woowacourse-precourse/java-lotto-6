package lotto.model;

import static lotto.model.enums.ErrorMessage.BLANK_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NOT_POSITIVE_INTEGER_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.NULL_INPUT_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AmountTest {
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("invalidParameter")
    @DisplayName("금액 검증")
    void invalidInput(String testName, String amount, String expectedErrorMessage) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    private static Stream<Arguments> invalidParameter() {
        return Stream.of(
                // null 예외
                Arguments.of("Null 예외 발생", null, NULL_INPUT_MESSAGE.getMessage()),

                // 빈값 + 공백 예외
                Arguments.of("빈값 예외 발생", "", BLANK_INPUT_MESSAGE.getMessage()),
                Arguments.of("공백 예외 발생", " ", BLANK_INPUT_MESSAGE.getMessage()),

                // 정수 아닐 경우 예외
                Arguments.of("문자열 예외 발생", "hot", NOT_INTEGER_INPUT_MESSAGE.getMessage()),
                Arguments.of("공백 포함 예외 발생", "h 2 3", NOT_INTEGER_INPUT_MESSAGE.getMessage()),
                Arguments.of("소수 예외 발생", "0.12", NOT_INTEGER_INPUT_MESSAGE.getMessage()),
                Arguments.of("특수 문자 포함 예외 발생", "h+1", NOT_INTEGER_INPUT_MESSAGE.getMessage()),

                // 0 + 음수 예외
                Arguments.of("0 예외 발생", "0", NOT_POSITIVE_INTEGER_INPUT_MESSAGE.getMessage()),
                Arguments.of("음수 예외 발생", "-10", NOT_POSITIVE_INTEGER_INPUT_MESSAGE.getMessage()),

                // 1000으로 나누어 떨어지지 않을 경우 예외 발생
                Arguments.of("1000의 배수 아닐 경우 예외 발생1", "123", NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE.getMessage()),
                Arguments.of("1000의 배수 아닐 경우 예외 발생2", "1120", NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE.getMessage())
        );
    }
}