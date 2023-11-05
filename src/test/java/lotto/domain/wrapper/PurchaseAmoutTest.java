package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmoutTest {
    @DisplayName("구입 금액이 0원 이하일 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    void createPurchaseAmountBylessThanOrEqualToZero(int purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmout(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_MONEY.getWithPrefix());
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않을 때 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {800, 1500, 8010})
    void createPurchaseAmountByChangeRemaining(int purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmout(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CHANGE_REMAINED.getWithPrefix());
    }
}