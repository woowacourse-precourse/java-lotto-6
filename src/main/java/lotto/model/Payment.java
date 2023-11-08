package lotto.model;

import static lotto.view.ExceptionMessage.DIVISION_ERROR;
import static lotto.view.ExceptionMessage.MIN_VALUE_ERROR;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ExceptionMessage;

public class Payment {
  private int payment;


  public void Payment(int payment) {
    this.payment = payment;
  }

  public int ticketNumber(int payment){
    int ticket = payment / 1000;
    return ticket;
  }
}
