package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private final ExceptionHandler exceptionHandler = new ExceptionHandler();

  private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
  private static final String LOTTO_NUM_REQUEST = "당첨 번호를 입력해 주세요.";
  private static final String BONUS_NUM_REQUEST = "보너스 번호를 입력해 주세요.";

  public int purchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_REQUEST);
    while (true) {
      try {
        return exceptionHandler.purchaseAmountException(Console.readLine().trim());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getLocalizedMessage());
      }
    }
  }

  public Lotto winningNum() {
    System.out.println(LOTTO_NUM_REQUEST);
    while (true) {
      try {
        return exceptionHandler.lottoNumException(Console.readLine().trim());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getLocalizedMessage());
      }
    }
  }

  public int bonusNum(Lotto winningNumbers) {
    System.out.println(BONUS_NUM_REQUEST);
    while (true) {
      try {
        return exceptionHandler.bonusNumException(winningNumbers.getNumbers(), Console.readLine().trim());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getLocalizedMessage());
      }
    }
  }
}
