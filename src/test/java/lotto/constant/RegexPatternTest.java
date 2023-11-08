package lotto.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RegexPatternTest의")
public class RegexPatternTest {

    @ParameterizedTest
    @DisplayName("숫자면 false를 반환하는가")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void check_with_number(String input) {
        //given & when
        final boolean actualresult = RegexPattern.isNotNumberic(input);

        //then
        assertThat(actualresult).isFalse();
    }

    @ParameterizedTest
    @DisplayName("문자면 false를 반환하는가")
    @ValueSource(strings = {"a1", "b1", "c1", "d32", "5k5", "a6"})
    void check_without_number(String input) {
        //given & when
        final boolean actualresult = RegexPattern.isNotNumberic(input);

        //then
        assertThat(actualresult).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 범위 내의 숫자면 false를 반환하는가")
    @ValueSource(ints = {1, 5, 11, 20, 30, 45})
    void check_valid_range(Integer input) {
        //given & when
        final boolean actualresult = RegexPattern.isLottoNumberUnavailable(input);

        //then
        assertThat(actualresult).isFalse();
    }

    @ParameterizedTest
    @DisplayName("로또 범위 내의 숫자면 true를 반환하는가")
    @ValueSource(ints = {0, 46})
    void check_invalid_range(Integer input) {
        //given & when
        final boolean actualresult = RegexPattern.isLottoNumberUnavailable(input);

        //then
        assertThat(actualresult).isTrue();
    }
}
