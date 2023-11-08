package lotto.domain;

import lotto.domain.payment.Payment;
import lotto.exception.PaymentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    Payment payment;

    @Test
    @DisplayName("금액을 입력하면 Payment 를 생성한다.")
    void CreatePaymentWhenInputAmount() {
        int amount = 1000;
        payment = Payment.of(amount);
        Assertions.assertEquals(Payment.class, payment.getClass());
        Assertions.assertEquals(payment.amount(), amount);
    }

    @Test
    @DisplayName("0이나 음수를 입력하면 예외를 발생한다.")
    void ThrowExceptionWhenInputZeroOrNegative() {
        int zeroAmount = 0;
        int negativeAmount = -1;

        var zeroException = Assertions.assertThrows(PaymentException.class, () -> {
            Payment.of(zeroAmount);
        });
        var negativeException = Assertions.assertThrows(PaymentException.class, () -> {
            Payment.of(negativeAmount);
        });
        Assertions.assertEquals(zeroException.getMessage(), negativeException.getMessage());
    }

    @Test
    @DisplayName("1000원 단위로 숫자를 입력하지 않으면 예외를 발생한다.")
    void ThrowExceptionWhenInputIsNotAlignedWithPaymentUnit() {
        int notAlignedAmount = 999;
        Assertions.assertThrows(PaymentException.class, () -> {
            Payment.of(notAlignedAmount);
        });
    }
}
