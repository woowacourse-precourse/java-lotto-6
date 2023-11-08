package lotto.domain;

import static lotto.utils.ConstantValues.LOTTO_PRICE;
import static lotto.utils.ConstantValues.MAX_NUMBER_OF_LOTTOS;
import static lotto.utils.ErrorMessages.CHANGE_REMAINING;
import static lotto.utils.ErrorMessages.PURCHASE_AMOUNT_LESS_THAN_OR_EQUAL_TO_ZERO;
import static lotto.utils.ErrorMessages.TOO_MUCH_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 0원 이하일 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    void createPurchaseAmountBylessThanOrEqualToZero(int purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_LESS_THAN_OR_EQUAL_TO_ZERO);
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않을 때 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {800, 1500})
    void createPurchaseAmountByChangeRemaining(int purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CHANGE_REMAINING);
    }

    @DisplayName("로또를 최대 허용 개수보다 많이 살 수 있는 구입 금액을 받은 경우 예외를 발생시킨다.")
    @Test
    void createPurchaseAmountByTooMuchMoney() {
        // given
        int purchaseAmount = LOTTO_PRICE * (MAX_NUMBER_OF_LOTTOS + 1);
        // when, then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TOO_MUCH_PURCHASE_AMOUNT, MAX_NUMBER_OF_LOTTOS));
    }

    @DisplayName("구입 금액으로 구입 가능한 로또 개수를 계산한다.")
    @Test
    void calculateAvailableLottoCount() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        int expectedLottoCount = 8;
        // when
        int availableLottoCount = purchaseAmount.getAvailableLottoCount();
        // then
        assertThat(availableLottoCount).isEqualTo(expectedLottoCount);
    }

    @DisplayName("구입 금액과 상금 비율로 총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);
        long profit = 5000L;
        double expectedProfitRate = 50.0;
        // when
        double profitRate = purchaseAmount.calculateProfitRate(profit);
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}