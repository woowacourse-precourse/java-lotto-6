package lotto.view;

import static lotto.view.ExceptionMessage.DIVISION_ERROR;
import static lotto.view.ExceptionMessage.INTEGER_ERROR;
import static lotto.view.ExceptionMessage.MIN_VALUE_ERROR;
import static lotto.view.ExceptionMessage.WINNING_DUPLICATE_ERROR;
import static lotto.view.ExceptionMessage.WINNING_RANGE_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
  public static final String PAMENT_MESSAGE = "구입금액을 입력해 주세요.";
  public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


  public int getPaymentInput() throws IllegalStateException {
    System.out.println(PAMENT_MESSAGE);
    int paymentInput = 0;

    try {
      String paymentInputString = Console.readLine();
      paymentInput = Integer.parseInt(paymentInputString);
      if (paymentInput <= 0) {
        throw new IllegalArgumentException(INTEGER_ERROR);
      }
      if (paymentInput < 1000) {
        throw new IllegalArgumentException(MIN_VALUE_ERROR);
      }
      if ((paymentInput % 1000) != 0) {
        throw new IllegalArgumentException(DIVISION_ERROR);
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("유효하지 않은 금액입니다.");
    }
    return paymentInput;
  }

  public List<Integer> getWinningInput() {
    List<Integer> winningList = new ArrayList<>();

    System.out.println(WINNING_NUMBER_MESSAGE);
    String result = Console.readLine();
    String[] winningInput = result.split(",");
    for (int i = 0; i < winningInput.length; i++) {
      try {
        int number = Integer.parseInt(winningInput[i].trim());
        winningList.add(number);
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] " + INTEGER_ERROR);
        winningList.clear();
        break;
      }
    }
    return winningList;
  }


  public int getBonusInput(List<Integer> winning) {
    System.out.println(BONUS_NUMBER_MESSAGE);
    while (true) {
      try {
        int bonusInput = Integer.parseInt(Console.readLine());
        if (bonusInput < 1 || bonusInput > 45) {
          throw new IllegalArgumentException(WINNING_RANGE_ERROR);
        } else if (winning.contains(bonusInput)) {
          throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR);
        } else {
          return bonusInput;
        }
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException(INTEGER_ERROR);
      }
    }
  }
}
