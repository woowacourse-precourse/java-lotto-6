package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

  private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
  private static final String LOTTERY_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
  private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

  @Override
  public String readPurchase() {
    System.out.println(PURCHASE_AMOUNT_PROMPT);
    return Console.readLine();
  }

  @Override
  public String readLotteryNumber() {
    System.out.println(LOTTERY_NUMBER_PROMPT);
    return Console.readLine();
  }

  @Override
  public String readBonusNumber() {
    System.out.println(BONUS_NUMBER_PROMPT);
    return Console.readLine();
  }
}
