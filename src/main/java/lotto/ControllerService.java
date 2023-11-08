package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class ControllerService {
  private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액이 유효하지 않습니다.";
  public static String isValidPurchaseAmount(String purchaseAmount) {
    try {
      // 문자열을 숫자로 변환하여 예외가 발생하지 않으면 숫자로 판단
      double d = Double.parseDouble(purchaseAmount);
    } catch (NumberFormatException e) {
      OutputView.printErrorMessage(PURCHASE_AMOUNT_ERROR_MESSAGE);
      isValidPurchaseAmount(InputView.getPurchaseAmount()); // 재귀 호출
    }
    // 정상적인 입력일 때 계속 진행
    return purchaseAmount;
  }

  public static String isValidWinningLotto(String winningLotto){
  return "a";
  }

}
