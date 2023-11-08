package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseAmountTest {
    private static final int LOTTO_UNIT = 1000;

    @DisplayName("입력한 구매 금액이 9223372036854000L 초과이면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountByOverValue() {
        assertThatThrownBy(() -> new PurchaseAmount(9223372036854001L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
    }

    @DisplayName("입력한 구매 금액이 1000 미만이면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountByUnderValue() {
        assertThatThrownBy(() -> new PurchaseAmount(999L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
    }

    @DisplayName("입력한 구매 금액의 단위가 1000이 아니면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountInvalidUnit() {
        assertThatThrownBy(() -> new PurchaseAmount(1111L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_UNIT.getMessage());
    }

    @DisplayName("입력한 구매 금액만큼 로또를 구매한다.")
    @ParameterizedTest
    @CsvSource(value = {"97000", "528000"})
    void purchaseLottoByInputAmount(int amount) {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        // when
        long createdLotto = purchaseAmount.calculateLottoCount();

        // then
        int expected = amount / LOTTO_UNIT;
        Assertions.assertEquals(expected, createdLotto);
    }
}