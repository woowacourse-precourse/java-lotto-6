package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public int inputMoney() {
    OutputView.printInputMoneyMessage();
    String money = Console.readLine();
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
