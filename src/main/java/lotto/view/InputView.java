package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

  public static int inputMoney() {
    OutputView.printInputMoneyMessage();
    String money = Console.readLine();
    PurchaseAmountValidator.isEmptyString(money);
    PurchaseAmountValidator.isAllIntegersValid(money);
    PurchaseAmountValidator.isAmountGreaterThanOrEqualTo1000(money);
    PurchaseAmountValidator.isDivisibleBy1000(money);
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
