package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("validWinningNumbersInputProvider")
    public void 자동차_이름_리스트_길이_테스트(List<LottoNumber> input, boolean expected) {
        assertThat(InputValidator.isValidWinningNumbers(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("invalidGameCountInputProvider")
    public void 사용자_게임_횟수_테스트(String input, boolean expected) {
        assertThat(InputValidator.isNumeric(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> validWinningNumbersInputProvider() { // argument source method
        return Stream.of(
                Arguments.of(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), true),

                Arguments.of(Collections.emptyList(), false),

                Arguments.of(List.of(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), false),

                Arguments.of(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(6)), false)
        );
    }

    private static Stream<Arguments> invalidGameCountInputProvider() { // argument source method
        return Stream.of(
                Arguments.of("", false),
                Arguments.of("-1", true),
                Arguments.of("1", true),
                Arguments.of("12", true),
                Arguments.of("a12A", false),
                Arguments.of("A12a", false)
        );
    }
}
