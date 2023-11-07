package lotto.domain;

import lotto.util.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class PurchasePriceTest {

    @Test
    @DisplayName("구매 금액으로 로또 개수를 계산한다.")
    void getPurchaseLottoAmount() {
        // Given
        Long purchaseAmount = 21000L;

        // When
        PurchasePrice purchasePrice = PurchasePrice.of(purchaseAmount);

        // Then
        assertThat(purchasePrice.getPurchaseLottoAmount()).isEqualTo(21);
    }

    @Test
    @DisplayName("수령한 총 당첨 금액으로 수익률을 계산한다.")
    void calcYieldBy() {
        // Given
        PurchasePrice purchasePrice = PurchasePrice.of(21000L);
        long totalWinningPrize = 3000L;

        // When
        Double yield = purchasePrice.calcYieldBy(totalWinningPrize);

        // Then
        assertThat(yield).isEqualTo(14.285714, within(0.001));
    }

    @Test
    @DisplayName("구매 금액이 로또 가격의 배수가 아닌 경우 예외를 던진다.")
    void invalidPurchaseAmount() {
        // Given
        Long invalidAmount = 1101L;

        // When, Then
        assertThatThrownBy(() -> PurchasePrice.of(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_UNIT_PRICE.getMessage());
    }
}