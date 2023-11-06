package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PaymentTest {
    private static final int LOTTO_PRICE = 1000;

    @Nested
    @DisplayName("지불 금액 예외 테스트")
    class PaymentValidateTest {
        @Test
        void 지불_금액은_로또_가격으로_나누어_떨어져야_한다() {
            assertThrows(IllegalArgumentException.class, () -> new Payment(LOTTO_PRICE + 1));
        }

        @Test
        void 지불_금액은_로또_가격보다_크거나_같아야한다() {
            assertThrows(IllegalArgumentException.class, () -> new Payment(LOTTO_PRICE - 1));
        }
    }

    @Test
    @DisplayName("지불 금액 통과 테스트")
    void legalPaymentTest() {
        assertDoesNotThrow(() -> new Payment(LOTTO_PRICE));
    }


}