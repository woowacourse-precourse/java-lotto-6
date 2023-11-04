package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("1000으로 나누어 떨어지지 않는 구입금액에 대해 예외를 던져야 한다.")
    @Test
    void invalidPurchaseAmout() {
        assertThatThrownBy(() -> new PurchaseAmount(1234))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(234))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertDoesNotThrow(() -> new PurchaseAmount(12000));
        Assertions.assertDoesNotThrow(() -> new PurchaseAmount(1000));
    }

}
