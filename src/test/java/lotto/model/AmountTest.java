package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.model.exceptions.NotDivisibleIntegerException;
import lotto.model.exceptions.NotIntegerException;
import lotto.model.exceptions.NotPositiveIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("invalidParameter")
    @DisplayName("금액 검증")
    void invalidAmountTest(String testName, String amount, Class<? extends IllegalArgumentException> exceptionClass) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(exceptionClass);
    }

    private static Stream<Arguments> invalidParameter() {
        return Stream.of(
                // null 예외
                Arguments.of("Null 예외 발생", null, NotIntegerException.class),

                // 빈값 + 공백 예외
                Arguments.of("빈값 예외 발생", "", NotIntegerException.class),
                Arguments.of("공백 예외 발생", " ", NotIntegerException.class),

                // 정수 아닐 경우 예외
                Arguments.of("문자열 예외 발생", "hot", NotIntegerException.class),
                Arguments.of("공백 포함 예외 발생", "h 2 3", NotIntegerException.class),
                Arguments.of("소수 예외 발생", "0.12", NotIntegerException.class),
                Arguments.of("특수 문자 포함 예외 발생", "h+1", NotIntegerException.class),

                // 0 + 음수 예외
                Arguments.of("0 예외 발생", "0", NotPositiveIntegerException.class),
                Arguments.of("음수 예외 발생", "-10", NotPositiveIntegerException.class),

                // 1000으로 나누어 떨어지지 않을 경우 예외 발생
                Arguments.of("1000의 배수 아닐 경우 예외 발생1", "123", NotDivisibleIntegerException.class),
                Arguments.of("1000의 배수 아닐 경우 예외 발생2", "1120", NotDivisibleIntegerException.class)
        );
    }

    @ParameterizedTest(name = "{index}: {0}원")
    @ValueSource(strings = {"1000", "2000", "3000", "4000", "5000"})
    @DisplayName("예외 발생 X")
    void correctAmountTest(String input) {
        assertThatCode(() -> new Amount(input))
                .doesNotThrowAnyException();
    }
}