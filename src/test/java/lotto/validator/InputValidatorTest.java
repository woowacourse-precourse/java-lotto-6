package lotto.validator;


import static lotto.validator.InputValidator.inRange;
import static lotto.validator.InputValidator.notNegative;
import static lotto.validator.InputValidator.onlyNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidatorTest {
    @ParameterizedTest
    @MethodSource
    void 숫자외에_문자가_존재할때_예외처리(String input) {
        //given

        //when
        Throwable result = catchThrowable(() -> onlyNumber(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 숫자외에_문자가_존재할때_예외처리() {
        return Stream.of(
                Arguments.of("가나다라"),
                Arguments.of("ABCD"),
                Arguments.of("~!@#")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 숫자의_범위를_벗어났을때에_예외처리(String input) {
        //given

        //when
        Throwable result = catchThrowable(() -> inRange(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 숫자의_범위를_벗어났을때에_예외처리() {
        return Stream.of(
                Arguments.of("1111111111111111"),
                Arguments.of("1111111111111111111"),
                Arguments.of("11111111111111111111111")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 음수에_대한_예외처리(String input) {
        //given

        //when
        Throwable result = catchThrowable(() -> notNegative(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 음수에_대한_예외처리() {
        return Stream.of(
                Arguments.of("-1"),
                Arguments.of("-10"),
                Arguments.of("-123456")
        );
    }
}
