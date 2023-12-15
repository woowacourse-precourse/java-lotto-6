package lotto.checker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentPriceCheckerTest {

    @DisplayName("구매금액이 음의 정수이면 예외를 발생한다.")
    @Test
    void getPaymentPriceByNegativeNumber() {
        assertThatThrownBy(() -> PaymentPriceChecker.positive(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 0이면 예외를 발생한다.")
    @Test
    void getPaymentPriceByZero() {
        assertThatThrownBy(() -> PaymentPriceChecker.positive(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000의 배수가 아니면 예외를 발생한다.")
    @Test
    void getPaymentPriceByNonMultipleOf1000() {
        assertThatThrownBy(() -> PaymentPriceChecker.multipleOfPrice(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
