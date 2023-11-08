package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseMoneyTest {
    @DisplayName("로또 금액이 정상적으로 입력되면 예외가 발생하지 않는다.")
    @Test
    void createPurchaseMoneyByNormal() {
        assertDoesNotThrow(() -> {
            new PurchaseMoney(3000);
        });
    }

    @DisplayName("로또 구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createPurchaseMoneyByUnder1000() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseMoney(999);
        });
    }

    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void createPurchaseMoneyByNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseMoney(-1000);
        });
    }

    @DisplayName("로또 구입 금액이 0이면 예외가 발생한다.")
    @Test
    void createPurchaseMoneyByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseMoney(0);
        });
    }

    @DisplayName("로또 구입 금액이 1000원 단위이면 예외가 발생하지 않는다.")
    @Test
    void createPurchaseMoneyBy1000() {
        assertDoesNotThrow(() -> {
            new PurchaseMoney(1000);
        });
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseMoneyByNot1000() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseMoney(1001);
        });
    }


}
