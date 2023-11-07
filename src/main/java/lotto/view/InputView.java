package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

  public static int inputMoney() {
    try {
      OutputView.printInputMoneyMessage();
      String money = Console.readLine();
      PurchaseAmountValidator.isEmptyString(money);
      PurchaseAmountValidator.isAllIntegersValid(money);
      PurchaseAmountValidator.isAmountGreaterThanOrEqualTo1000(money);
      PurchaseAmountValidator.isDivisibleBy1000(money);
      return Integer.parseInt(money);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return inputMoney();
    }
  }


  public static String inputWinningNumber() {
    OutputView.printInputWinningNumberMessage();
    return Console.readLine();
  }

  public static int inputBonusNumber(List<Integer> winningNumberSet) {
    try{
      OutputView.printInputBonusNumberMessage();
      String bonusNumber = Console.readLine();
      BonusNumberValidator.isValueInRange(bonusNumber);
      BonusNumberValidator.isAllIntegersValid(bonusNumber);
      BonusNumberValidator.isEmptyString(bonusNumber);
      BonusNumberValidator.isDuplicate(winningNumberSet, bonusNumber);
      return Integer.parseInt(bonusNumber);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return inputBonusNumber(winningNumberSet);
    }
  }
}
