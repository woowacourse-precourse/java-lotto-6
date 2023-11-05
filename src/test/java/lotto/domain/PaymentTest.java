package lotto.domain;

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
}
