package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ControllerService {
  private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액이 유효하지 않습니다.";
  private static final String INVALID_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호가 유효하지 않습니다.";

  public static String isValidPurchaseAmount(String purchaseAmount) {
    try {
      // 문자열을 숫자로 변환하여 예외가 발생하지 않으면 숫자로 판단
      int canInteger = Integer.parseInt(purchaseAmount);
    } catch (NumberFormatException e) {
      OutputView.printErrorMessage(PURCHASE_AMOUNT_ERROR_MESSAGE);
      isValidPurchaseAmount(InputView.getPurchaseAmount()); // 재귀 호출
    }
    // 정상적인 입력일 때 계속 진행
    return purchaseAmount;
  }

  public static String isValidWinningNumber(String winningNumbers) {
    try {
      List<Integer> winningNumber = Arrays.stream(winningNumbers.split(","))
          .map(String::trim)
          .map(Integer::parseInt)
          .toList();

    } catch (NumberFormatException e) {
      OutputView.printErrorMessage(INVALID_WINNING_NUMBER_ERROR_MESSAGE);
      return isValidWinningNumber(InputView.getWinningNumber()); // 재귀 호출
    }
    return winningNumbers;
  }

}
