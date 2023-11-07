package lotto.domain.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void purchaseAmountByNotNumber() {
        assertThatThrownBy(() -> new PurchaseAmount("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}