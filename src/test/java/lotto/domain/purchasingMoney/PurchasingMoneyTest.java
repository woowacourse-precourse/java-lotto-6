package lotto.domain.purchasingMoney;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchasingMoneyTest {

    private final int CASH_UNIT = PurchasingMoneyConfig.CASH_UNIT.getValue();

    @DisplayName("돈을 생성 시 단위에 대해,")
    @Nested
    class validateCashUnit {

        @DisplayName("단위와 맞지 않는 값으로 생성 시 예외가 발생한다.")
        @Test
        void createWithInvalidUnit() {
            // given
            int amount = CASH_UNIT + 1;

            // when & then
            Assertions.assertThatThrownBy(() -> new PurchasingMoney(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchasingMoneyExceptionMessages.INVALID_CASH_UNIT.getMessage());
        }

        @DisplayName("단위와 맞는 값으로 생성 시 예외가 발생하지 않는다.")
        @Test
        void createWithValidUnit() {
            // given
            int amount = CASH_UNIT;

            // when & then
            Assertions.assertThatCode(() -> new PurchasingMoney(amount))
                    .doesNotThrowAnyException();
        }

    }


    @DisplayName("돈을 생성 시 양수인가에 대해,")
    @Nested
    class validatePositive {

        @DisplayName("0으로 생성 시 예외가 발생한다.")
        @Test
        void createWithZero() {
            // given
            int amount = 0;

            // when & then
            Assertions.assertThatThrownBy(() -> new PurchasingMoney(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchasingMoneyExceptionMessages.NEGATIVE_OR_ZERO.getMessage());
        }

        @DisplayName("음수로 생성 시 예외가 발생한다.")
        @Test
        void createWithNegative() {
            // given
            int amount = -CASH_UNIT;

            // when & then
            Assertions.assertThatThrownBy(() -> new PurchasingMoney(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchasingMoneyExceptionMessages.NEGATIVE_OR_ZERO.getMessage());
        }

        @DisplayName("양수로 생성 시 예외가 발생하지 않는다.")
        @Test
        void createWithPositive() {
            // given
            int amount = CASH_UNIT;

            // when & then
            Assertions.assertThatCode(() -> new PurchasingMoney(amount))
                    .doesNotThrowAnyException();
        }

    }

    @DisplayName("돈을 지불했을 때, 알맞는 개수의 로또를 판매한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "3000,3"})
    void purchaseTest(int amount, int expectedCount) {
        // when
        PurchasingMoney purchasingMoney = new PurchasingMoney(amount);
        int lotteriesCount = purchasingMoney.countPurchasableAmount();

        // then
        Assertions.assertThat(lotteriesCount)
                .isEqualTo(expectedCount);
    }

    @DisplayName("로또 구매액 한도에 대해,")
    @Nested
    class validateLimit {

        @DisplayName("구매 한도액 초과 시, 예외가 발생한다.")
        @Test
        void createWithOverPurchaseLimit() {
            // given
            int purchaseLimitValue = PurchasingMoneyConfig.LOTTO_PURCHASE_LIMIT.getValue();
            int oneLottoPriceValue = PurchasingMoneyConfig.LOTTO_PRICE.getValue();
            int overLimitValue = purchaseLimitValue + oneLottoPriceValue;

            // when & then
            Assertions.assertThatThrownBy(() -> new PurchasingMoney(overLimitValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(PurchasingMoneyExceptionMessages.LOTTO_PURCHASE_OVER_LIMIT.getMessage());
        }

        @DisplayName("구매 한도액으로 구매 시, 예외가 발생하지 않는다.")
        @Test
        void createWithPurchaseLimit() {
            // given
            int purchaseLimitValue = PurchasingMoneyConfig.LOTTO_PURCHASE_LIMIT.getValue();

            // when & then
            Assertions.assertThatCode(() -> new PurchasingMoney(purchaseLimitValue))
                    .doesNotThrowAnyException();
        }

    }

}
