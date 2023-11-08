package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PaymentTest {

  @Test
  @DisplayName("구매한 로또 개수 확인")
  void ticketNumberTest(){
    Payment payment = new Payment();
    assertThat(payment.ticketNumber(3000)).isEqualTo(3);
  }

}