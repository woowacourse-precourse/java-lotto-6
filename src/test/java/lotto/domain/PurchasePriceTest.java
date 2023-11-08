package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchasePriceTest {

    @Test
    void 금액이_1000으로_안나눠떨어짐() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchasePrice(123);});
    }

    @Test
    void 금액이_0임() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchasePrice(0);});
    }

    @Test
    void 금액이_음수임() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchasePrice(-1000);});
    }
}