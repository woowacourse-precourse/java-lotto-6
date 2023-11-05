package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPriceTest {

    @DisplayName("구입 금액이 1000원 단위가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { 1001, 900, 100 })
    void calculateInvalidMoney(int money){
        LottoPrice lottoPrice = LottoPrice.CURRENT;
        assertThatThrownBy(() -> lottoPrice.calculate(money))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액을 1000원 단위로 나눌 수 있다.")
    @ParameterizedTest
    @CsvSource(value = { "1000:1", "2000:2", "100000:100"}, delimiter = ':')
    void calculate(int money, int expected){
        LottoPrice lottoPrice = LottoPrice.CURRENT;
        assertThat(lottoPrice.calculate(money)).isEqualTo(expected);
    }


}