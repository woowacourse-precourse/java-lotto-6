package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    private final PaymentService paymentService = new PaymentService();
    @Test
    void testGetLottoCount() {
        int totalPrice = 5000;
        int expectedLottoCount = 5;

        int actualLottoCount = paymentService.getLottoCount(totalPrice);

        assertThat(expectedLottoCount).isEqualTo(actualLottoCount);
    }
//    @Test
//    void testGetLottoCountWithNonMultipleOfLottoPrice() {
//        int totalPrice = 5500;
//
//        assertThatThrownBy(() -> paymentService.getLottoCount(totalPrice))
//            .isInstanceOf(IllegalArgumentException.class)
//            .hasMessageContaining("로또 가격에 나누어 떨어지지 않는 금액입니다.");
//    }
}
