package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    Validation validation = new Validation();

    @Test
    void purchaseAmountException_notNumber() {
        String input = "1,000";

        assertThatThrownBy(() -> validation.purchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void purchaseAmountException_notMultipleOf1000() {
        String input = "3400";

        assertThatThrownBy(() -> validation.purchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
