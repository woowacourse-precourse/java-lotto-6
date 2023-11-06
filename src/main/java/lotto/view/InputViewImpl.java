package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView{

  @Override
  public String amountOfLotto() {
    return Console.readLine();
  }
}
