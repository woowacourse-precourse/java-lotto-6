package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
  public static final String PaymentMessage = "구입금액을 입력해 주세요.";

  public int getPaymentInput() {
    System.out.println(PaymentMessage);
    int paymentInput = 0;

    try {
      paymentInput = Integer.parseInt(Console.readLine());
    } catch (NumberFormatException e) {
      ExceptionMessage.typeException();
      throw new IllegalArgumentException();
    }
    return paymentInput;
  }
}
