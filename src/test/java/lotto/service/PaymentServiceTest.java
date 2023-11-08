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
}
