package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PaymentTest {

    @DisplayName("Payment 객체 생성을 실패한다.")
    @Test
    void createSuccessTest() {
        assertThatThrownBy(() -> new Payment(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}