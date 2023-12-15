package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @DisplayName("가격이 1000으로 안 나누어지면 예외가 발생한다.")
    @Test
    void priceThrowError() {
        assertThrows(IllegalStateException.class, () -> {
            PurchasePrice purchasePrice = new PurchasePrice(1500);
        });
    }

    @DisplayName("수익률 정상 출력")
    @Test
    void getReturnRate() {
        PurchasePrice purchasePrice = new PurchasePrice(8000);
        assertEquals(62.5, purchasePrice.getReturnRate(5000));

    }

    @DisplayName("가격이 1000원 이하면 에러발생")
    @Test
    void priceUnderLottoPrice() {
        assertThrows(IllegalStateException.class, () -> {
            new PurchasePrice(10);
        });
    }
}