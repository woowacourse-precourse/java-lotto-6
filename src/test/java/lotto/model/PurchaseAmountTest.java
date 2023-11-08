package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseAmountTest {

    @DisplayName("구입 금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByOutOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(500))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByOutOfUnit() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(1500))
                .withMessageContaining("[ERROR]");
    }
}
