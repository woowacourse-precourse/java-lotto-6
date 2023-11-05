package domain;

import lotto.domain.LottoErrorMessages;
import lotto.domain.LottoPurchaseCalculator;
import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;

public class LottoPurchaseCalculatorTest {

    @ParameterizedTest
    @CsvSource({"1000, 3000, 3", "1000, 2000, 2", "500, 1500, 3"})
    @DisplayName("올바른 금액과 가격으로 로또 개수 계산")
    void validLottoCount(int price, int amount, int expected) {
        LottoPurchaseCalculator calculator = new LottoPurchaseCalculator();
        Money money = new Money(amount);

        int count = calculator.calculateLottoCount(price, money);

        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 3000", "-100, 3000"})
    @DisplayName("부적절한 로또 가격으로 인한 예외 발생")
    void invalidPrice(int price, int amount) {
        LottoPurchaseCalculator calculator = new LottoPurchaseCalculator();
        Money money = new Money(amount);

        assertThatThrownBy(() -> calculator.calculateLottoCount(price, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessages.INVALID_LOTTO_PRICE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1000, 2500", "500, 800"})
    @DisplayName("나누어 떨어지지 않는 금액으로 인한 예외 발생")
    void nonDivisibleAmount(int price, int amount) {
        LottoPurchaseCalculator calculator = new LottoPurchaseCalculator();
        Money money = new Money(amount);

        assertThatThrownBy(() -> calculator.calculateLottoCount(price, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessages.NOT_DIVISIBLE_AMOUNT.getMessage());
    }
}