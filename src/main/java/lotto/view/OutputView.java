package lotto.view;

import java.util.List;

public class OutputView {
  private final static String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
  private final static String INPUT_WINNINGNUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  private final static String INPUT_BOUNSNUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
  public static void printInputMoneyMessage() {
    System.out.println(INPUT_MONEY_MESSAGE);
  }

  public static void printInputWinningNumberMessage() {
    System.out.println(INPUT_WINNINGNUMBER_MESSAGE);
  }

  public static void printInputBonusNumberMessage() {
    System.out.println(INPUT_BOUNSNUMBER_MESSAGE);
  }

  public String printtLottoNumbers(List<Integer> lottoNumbers) {
    String formattedNumbers = "[";

    for (int i = 0; i < lottoNumbers.size(); i++) {
      formattedNumbers += lottoNumbers.get(i);
      if (i < lottoNumbers.size() - 1) {
        formattedNumbers += ", ";
      }
    }

    formattedNumbers += "]";
    return formattedNumbers;
  }

}
