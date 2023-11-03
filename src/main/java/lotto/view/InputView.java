package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public int inputMONEY() {
    OutputView.printInputMoneyMessage();
    String money = Console.readLine();
    return Integer.parseInt(money);
  }

  public String inputWinningNumber() {
    OutputView.printInputWinningNumberMessage();
    return Console.readLine();
  }

  public String inputBonusNumber() {
    OutputView.printInputBonusNumberMessage();
    return Console.readLine();
  }
}
