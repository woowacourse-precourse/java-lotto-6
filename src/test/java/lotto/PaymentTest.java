package lotto;

import lotto.domain.lotto.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.")
    void test() {
        assertThatThrownBy(
                () -> {
                    Payment payment = Payment.of(999);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지는 경우 발행한 로또 수량을 반환한다.")
    void count() {
        Payment payment = Payment.of(10000);
        assertThat(payment.getLottoCount()).isEqualTo(10);
    }
}