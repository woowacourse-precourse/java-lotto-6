package lotto.domain;

import lotto.exception.PaymentException;
import lotto.exception.PaymentExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    Payment payment;
    @Test
    @DisplayName("금액을 입력하면 Payment 를 생성한다.")
    void CreatePaymentWhenInputAmount(){
        int amount = 1000;
        payment = new Payment(amount);
        Assertions.assertEquals(Payment.class,payment.getClass());
        Assertions.assertEquals(payment.amount(),amount);
    }
    @Test
    @DisplayName("0이나 음수를 입력하면 예외를 발생한다.")
    void ThrowExceptionWhenInputZeroOrNegative(){
        int zeroAmount = 0;
        int negativeAmount = -1;

        var zeroException = Assertions.assertThrows(PaymentException.class,()->{
            new Payment(zeroAmount);
        });
        var negativeException = Assertions.assertThrows(PaymentException.class,()->{
            new Payment(negativeAmount);
        });
        Assertions.assertEquals(zeroException.getMessage(),negativeException.getMessage());
    }
}
