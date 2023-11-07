package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {

  @Test
  @DisplayName("구매한 로또 개수 확인")
  void ticketNumberTest(){
    Payment payment = new Payment();
    assertThat(payment.ticketNumber(3000)).isEqualTo(3);
  }

}