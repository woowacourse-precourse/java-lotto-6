package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class Output {

  public static void printPurchasedLottoCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void printGeneratedLottoNumbers(List<Lotto> lottoTickets) {
    System.out.println("생성된 로또 번호:");
    for (Lotto lotto : lottoTickets) {
      for (int number : lotto.getNumbers()) {
        System.out.print("[" + number + "] ");
      }
      System.out.println();
    }
  }


  public static void printResult(String result) {
    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println(result);
    // Todo: 각 등수별 통계 템플릿 제작
  }

  public static void printProfitRate(double profitRate) {
    System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
  }
}
