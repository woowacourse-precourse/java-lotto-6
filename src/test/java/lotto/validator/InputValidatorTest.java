package lotto.validator;


import static lotto.validator.InputValidator.divisibleUnit;
import static lotto.validator.InputValidator.inRange;
import static lotto.validator.InputValidator.onlyNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
 *  사용자 입력에 대한 테스트 코드
 * */

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
    void 로또의_값으로_나눠지지_않을때_예외처리(int input) {
        //given

        //when
        Throwable result = catchThrowable(() -> divisibleUnit(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 로또의_값으로_나눠지지_않을때_예외처리() {
        return Stream.of(
                Arguments.of(100),
                Arguments.of(50),
                Arguments.of(0)
        );
    }

}
