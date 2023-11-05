package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

  public static int inputMoney() {
    OutputView.printInputMoneyMessage();
    String money = Console.readLine();
    PurchaseAmountValidator.validateAllIntegers(money);
    return Integer.parseInt(money);
  }

  public String inputWinningNumber() {
    OutputView.printInputWinningNumberMessage();
    return Console.readLine();
  }

  public int inputBonusNumber() {
    OutputView.printInputBonusNumberMessage();
    String bonusNumber = Console.readLine();
    return Integer.parseInt(bonusNumber);
  }
}
