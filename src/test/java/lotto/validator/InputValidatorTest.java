package lotto.validator;


import static lotto.validator.InputValidator.inNumberRange;
import static lotto.validator.InputValidator.onlyNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.view.Input;
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
        Throwable result = catchThrowable(() -> inNumberRange(input));
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
    void 콤마를_기준으로_숫자외에_문자가_존재할때_예외처리(String input) {
        //given
        List<String> dividedInput = Arrays.stream(input.split(Input.SEPARATION_SIGN))
                .toList();
        //when
        Throwable result = catchThrowable(() -> dividedInput.forEach(InputValidator::onlyNumber));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 콤마를_기준으로_숫자외에_문자가_존재할때_예외처리() {
        return Stream.of(
                Arguments.of("ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ,ㅅ"),
                Arguments.of("a,b,c,d,e,f,g"),
                Arguments.of("-1,-2,-3,-4,-5,-6"),
                Arguments.of("~,!,@,#,$,%")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 콤마를_기준으로_숫자의_최대범위를_벗어났을때_예외처리(String input) {
        //given
        List<String> dividedInput = Arrays.stream(input.split(Input.SEPARATION_SIGN))
                .toList();
        //when
        Throwable result = catchThrowable(() -> dividedInput.forEach(InputValidator::inNumberRange));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 콤마를_기준으로_숫자의_최대범위를_벗어났을때_예외처리() {
        return Stream.of(
                Arguments.of("111111111111111111111111111111111111111,2,3,4,5,6"),
                Arguments.of(",1,2222222222222222222222222,3,4,5,6"),
                Arguments.of("1,2,333333333333333333333333333333334,5,6"),
                Arguments.of("1,2,3,4,55555555555555555555,6")
        );
    }
}
