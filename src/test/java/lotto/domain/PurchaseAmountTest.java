package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @DisplayName("로또 구매 금액이 로또 하나의 금액 미만이라면 예외가 발생한다.")
    @Test
    void 로또_최소구매금액_예외처리_검증() {
        int invalidAmount = 700;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PurchaseAmount.from(invalidAmount);
        });

        assertTrue(exception.getMessage().contains("[ERROR]"));
    }

    @DisplayName("로또 구매 금액이 로또 하나 금액의 배수가 아니라면 예외가 발생한다.")
    @Test
    void 로또_구매금액_배수_예외처리_검증() {
        int invalidAmount = 1010;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PurchaseAmount.from(invalidAmount);
        });

        assertTrue(exception.getMessage().contains("[ERROR]"));
    }
}