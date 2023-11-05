package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.Bonus;
import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputConvertorTest {

    @ParameterizedTest
    @CsvSource(value = {"'8000', 8000", "'4000', 4000"})
    void convertMoney는_문자열을_Money객체로_변환한다(String input, int output) {
        // when
        Money result = InputConvertor.convertMoney(input);
        // then
        assertThat(result.requestLottoCount()).isEqualTo(Money.from(output).requestLottoCount());
    }

    @ParameterizedTest
    @CsvSource(value = {"'1', 1", "'2', 2", "'45', 45"})
    void convertBonus는_문자열을_Bonus객체로_변환한다(String input, int output) {
        // when
        Bonus result = InputConvertor.convertBonus(input);
        // then
        assertThat(result.getBonus()).isEqualTo(output);
    }

}