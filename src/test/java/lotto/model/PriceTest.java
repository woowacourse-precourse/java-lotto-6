package lotto.model;

import lotto.constant.response.Exception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @DisplayName("구입 금액이 1000원 단위가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 900, 100})
    void divideInvalidMoney(int money) {
        Price lottoPrice = Price.LOTTO;
        assertThatThrownBy(() -> lottoPrice.divide(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.ERROR_PREFIX.getMessage())
                .hasMessageContaining(Exception.LOTTO_PRICE.getMessage());
    }

    @DisplayName("구입 금액을 1000원 단위로 나눌 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "100000:100"}, delimiter = ':')
    void divide(int money, int expected) {
        Price lottoPrice = Price.LOTTO;
        assertThat(lottoPrice.divide(money)).isEqualTo(expected);
    }


}