package lotto.domain;

import static lotto.ErrorMessage.PAYMENT_LESS_THAN_1000;
import static lotto.ErrorMessage.PAYMENT_MORE_THAN_100000;
import static lotto.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_1000;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    @DisplayName("천원보다 적은 돈을 지불하면 예외가 발생한다")
    void createPaymentByLessThan1000() {
        assertThatThrownBy(() -> new Payment(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PAYMENT_LESS_THAN_1000.get());
    }

    @Test
    @DisplayName("십만원보다 큰 돈을 지불하면 예외가 발생한다")
    void createPaymentByMoreThan100000() {
        assertThatThrownBy(() -> new Payment(1500000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PAYMENT_MORE_THAN_100000.get());
    }

    @Test
    @DisplayName("1000으로 안나누어 떨어지면 예외가 발생한다")
    void createPaymentByCanNotDivision() {
        assertThatThrownBy(() -> new Payment(34300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PAYMENT_NOT_DIVISIBLE_BY_1000.get());
    }

    @Test
    @DisplayName("구매가능한 로또갯수를 리턴한다.")
    void testNumberLottoTicketsCanBuy() {
        Payment payment = new Payment(45000);

        int result = payment.numberLottoTicketsCanBuy();
        int expected = 45;

        assertThat(result).isEqualTo(expected);
    }
}
