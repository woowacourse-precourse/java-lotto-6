package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
  public static final String PAMENT_MESSAGE = "구입금액을 입력해 주세요.";
  public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

  public int getPaymentInput() {
    System.out.println(PAMENT_MESSAGE);
    int paymentInput = 0;

    try {
      paymentInput = Integer.parseInt(Console.readLine());
    } catch (NumberFormatException e) {
      ExceptionMessage.typeException();
      throw new IllegalArgumentException();
    }
    return paymentInput;
  }

  public List<Integer> getWinningInput(){
    List<Integer> winningList = new ArrayList<>();

    System.out.println(WINNING_NUMBER_MESSAGE);
    String result = Console.readLine();
    String[] winningInput = result.split(",");
    for(int i = 0; i < winningInput.length; i++){
      winningList.add(conventToInt(winningInput[i]));
    }
    return winningList;
  }

  private static int conventToInt(String inputNumber){
    try {
      return Integer.parseInt(inputNumber);
    } catch (NumberFormatException e){
      ExceptionMessage.typeException();
      throw new IllegalArgumentException();
    }
  }

  public int getBonusInput() {
    System.out.println(BONUS_NUMBER_MESSAGE);
    int BonusInput = 0;

    try {
      BonusInput = Integer.parseInt(Console.readLine());
    } catch (NumberFormatException e) {
      ExceptionMessage.typeException();
      throw new IllegalArgumentException();
    }
    return BonusInput;
  }
}
