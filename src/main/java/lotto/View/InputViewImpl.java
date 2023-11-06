package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

  private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

  @Override
  public String readPurchase() {
    System.out.println(PURCHASE_AMOUNT_PROMPT);
    return Console.readLine();
  }
}
