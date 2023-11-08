package lotto.View;

import java.util.List;

public class Output {

  public static void printPurchasedLottoCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void printGeneratedLottoNumbers(List<List<Integer>> lottoNumbers) {
    System.out.println("생성된 로또 번호:");
    for (List<Integer> numbers : lottoNumbers) {
      for (int number : numbers) {
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
