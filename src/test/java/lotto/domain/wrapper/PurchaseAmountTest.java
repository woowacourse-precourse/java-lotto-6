package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
                .hasMessageContaining(ErrorMessage.NO_PURCHASE_AMOUNT.getWithPrefix());
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않을 때 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {800, 1500})
    void createPurchaseAmountByChangeRemaining(int purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CHANGE_REMAINING.getWithPrefix());
    }

    @DisplayName("로또를 최대 허용 개수보다 많이 살 수 있는 구입 금액을 받은 경우 예외를 발생시킨다.")
    @Test
    void createPurchaseAmountByTooMuchMoney() {
        // given
        int samplePurchaseAmount =
                (LottoConstantValue.LOTTO_PRICE.get() * LottoConstantValue.MAX_NUMBER_OF_LOTTOS.get())
                        + LottoConstantValue.LOTTO_PRICE.get();
        // when, then
        assertThatThrownBy(() -> new PurchaseAmount(samplePurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TOO_MUCH_PURCHASE_AMOUNT.getWithFormatAndPrefix(
                        LottoConstantValue.MAX_NUMBER_OF_LOTTOS.get())
                );
    }

    @DisplayName("구입 금액으로 구입 가능한 로또 개수를 계산한다.")
    @Test
    void calculateAvailableLottoCount() {
        // given
        int samplePurchaseAmount = LottoConstantValue.LOTTO_PRICE.get() * 8;
        int expectedLottoCount = 8;
        PurchaseAmount purchaseAmount = new PurchaseAmount(samplePurchaseAmount);
        // when
        int availableLottoCount = purchaseAmount.getAvailableLottoCount();
        // then
        assertThat(availableLottoCount).isEqualTo(expectedLottoCount);
    }

    @DisplayName("구입 금액과 상금 비율로 총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        int samplePurchaseAmount = 10000;
        long sampleProfit = 5000L;
        double expectedProfitRate = 50.0;
        PurchaseAmount purchaseAmount = new PurchaseAmount(samplePurchaseAmount);
        // when
        double profitRate = purchaseAmount.calculateProfitRate(sampleProfit);
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}