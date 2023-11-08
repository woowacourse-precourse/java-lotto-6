package lotto.domain;

import lotto.util.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class PurchaseCostTest {

    @Test
    @DisplayName("구매 금액으로 로또 개수를 계산한다.")
    void getPurchaseLottoAmount() {
        // Given
        Long purchaseAmount = 21000L;

        // When
        PurchaseCost purchaseCost = PurchaseCost.of(purchaseAmount);

        // Then
        assertThat(purchaseCost.getPurchaseLottoAmount()).isEqualTo(21);
    }

    @Test
    @DisplayName("수령한 총 당첨 금액으로 수익률을 계산한다.")
    void calcYieldBy() {
        // Given
        PurchaseCost purchaseCost = PurchaseCost.of(21000L);
        Long totalWinningPrize = 3000L;

        // When
        Double yield = purchaseCost.calcYieldBy(totalWinningPrize);

        // Then
        assertThat(yield).isEqualTo(14.285714, within(0.001));
    }

    @Test
    @DisplayName("구매 금액이 로또 가격의 배수가 아닌 경우 예외를 던진다.")
    void invalidPurchaseAmount() {
        // Given
        Long invalidAmount = 1101L;

        // When, Then
        assertThatThrownBy(() -> PurchaseCost.of(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_UNIT_PRICE.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 1000원 미만일 경우 예외를 던진다.")
    void invalidPurchaseAmountUnder1000won() {
        // Given
        Long invalidAmount = 0L;
        Long invalidAmount2 = -1000L;

        // When, Then
        assertThatThrownBy(() -> PurchaseCost.of(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_POSITIVE_NATURAL_NUMBER.getMessage());
        assertThatThrownBy(() -> PurchaseCost.of(invalidAmount2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_POSITIVE_NATURAL_NUMBER.getMessage());
    }
}