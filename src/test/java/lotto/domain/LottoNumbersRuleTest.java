package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersRuleTest {

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @CsvSource(value = {"0:true", "46:true", "1:false", "45:false"}, delimiter = ':')
    @DisplayName("로또 번호가 범위 내 숫자인가: 범위를 벗어난 경우 true, 범위 내이면 false")
    void givenNumber_whenHasOutOfRangeNumber_thenReturnBooleanResult(int number, boolean expected) {
        // when
        boolean result = LottoNumbersRule.hasOutOfRangeNumber(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForIsLottoNumbersSizeMismatched")
    @DisplayName("로또 번호가 6개가 아닌가: 아닌 경우 true, 6개 이면 false")
    void givenNumbers_whenIsLottoNumbersSizeMismatched_thenReturnResult(List<Integer> numbers, boolean expected) {
        // when
        boolean result = LottoNumbersRule.isLottoNumbersSizeMismatched(numbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideDataForIsLottoNumbersSizeMismatched() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), false)
        );
    }

}
