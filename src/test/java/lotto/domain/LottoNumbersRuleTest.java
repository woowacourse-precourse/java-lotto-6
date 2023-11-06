package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumbersRuleTest {

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @CsvSource(value = {"0:true", "46:true", "1:false", "45:false"}, delimiter = ':')
    @DisplayName("로또 번호가 범위 내 숫자인가: 범위를 벗어난 경우 true, 범위 내이면 false")
    void givenNumber_whenHasOutOfRangeNumber_thenReturnBooleanResult(int number, boolean expected) {
        // when
        boolean result = LottoNumbersRule.hasOutOfRangeNumber(number);

        // then
        assertEquals(expected, result);
    }

}
