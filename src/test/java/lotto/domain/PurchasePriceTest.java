package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @DisplayName("가격이 1000으로 안 나누어지면 예외가 발생한다.")
    @Test
    void priceThrowError() {
        assertThrows(IllegalStateException.class, ()->{
            PurchasePrice purchasePrice = new PurchasePrice(1500);
        });
    }
}