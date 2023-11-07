package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ExceptionMessage;

public class Payment {
  private int payment;
  public static final String TypeError = "[ERROR] 1,000원 단위의 숫자를 입력해야 합니다.";


  public void Payment(int payment) {
    validatePayment(payment);
    this.payment = payment;
  }

  private void validatePayment(int payment) {
    if (payment < 1000) {
      ExceptionMessage.minException();
      throw new IllegalArgumentException();
    }
    if ((payment % 1000) != 0) {
      ExceptionMessage.divisionException();
      throw new IllegalArgumentException();
    }
  }

  public int ticketNumber(int payment){
    int ticket = payment / 1000;
    return ticket;
  }
}
