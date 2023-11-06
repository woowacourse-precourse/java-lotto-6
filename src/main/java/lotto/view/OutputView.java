package lotto.view;

import java.util.List;
import lotto.controller.InputProcessor;
import lotto.model.Ranking;

public class OutputView {
  private final static String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
  private final static String INPUT_WINNINGNUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  private final static String INPUT_BOUNSNUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
  private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
  private static InputProcessor inputProcessor = new InputProcessor();

  public static void printInputMoneyMessage() {
    System.out.println(INPUT_MONEY_MESSAGE);
  }

  public static void printInputWinningNumberMessage() {
    System.out.println(INPUT_WINNINGNUMBER_MESSAGE);
  }

  public static void printInputBonusNumberMessage() {
    System.out.println(INPUT_BOUNSNUMBER_MESSAGE);
  }

  public static void printLottoCountMessage(int calculateLottoCount) {
    System.out.print(calculateLottoCount);
    System.out.println(LOTTO_COUNT_MESSAGE);
  }

  public static String printLottoNumbers(List<Integer> lotto) {
    StringBuilder formattedLotto = new StringBuilder("[");

    for (int i = 0; i < lotto.size(); i++) {
      formattedLotto.append(lotto.get(i));
      if (i < lotto.size() - 1) {
        formattedLotto.append(", ");
      }
    }

    formattedLotto.append("]");
    return formattedLotto.toString();
  }

  public static void printLottos(List<List<Integer>> lottos) {
    for (List<Integer> lotto : lottos) {
      String formattedLotto = printLottoNumbers(lotto);
      System.out.println(formattedLotto);
    }
  }

  public static void printSuccessResult() {
    System.out.println("당첨 통계");
    System.out.println("---");
  }

  public static void printRanking(List<Integer> rank) {
    Ranking[] rankings = Ranking.values();
    for (int i = rankings.length-2; i >= 0; i--) {
      int count = rank.get(i);
      String message = rankings[i].getMessage();
      System.out.println(message + count + "개");
    }
  }


  public static void printProfitability(String formattedValue){

    System.out.println("총 수익률은 " + String.format("%s", formattedValue) + "%입니다.");
  }

}
