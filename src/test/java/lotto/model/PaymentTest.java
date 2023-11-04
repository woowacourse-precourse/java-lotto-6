package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void 로또_금액이_1000원_단위인지_검증() {
        assertThatThrownBy(() -> new Payment("2222"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액을 정수가 아닌 문자를 입력하면 예외가 발생한다.")
    void 로또_금액이_숫자인지_검증() {
        assertThatThrownBy(() -> new Payment("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 가격으로 로또를 발행한다.")
    void 발행하는_로또의_개수를_검증() {
        Payment payment = new Payment("8000");
        assertThat(8).isEqualTo(payment.getTicket());
    }
}