package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public String inputMONEY() {
    OutputView.printInputMoneyMessage();
    return Console.readLine();
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
