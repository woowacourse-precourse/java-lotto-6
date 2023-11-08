package lotto.domain;

import static lotto.domain.Input.LOTTO_PRICE;

import java.util.List;
import lotto.Lotto;

public class Output {
  public static void printLottoCount(int LottoPurchaseAmount) {
    List<Integer>[] user = new List[LottoPurchaseAmount / LOTTO_PRICE];
    System.out.println((LottoPurchaseAmount / LOTTO_PRICE) + "개를 구매했습니다.");
  }

  public static void printLotto(Lotto[] myLotto) {
    for (Lotto lotto : myLotto) {
      System.out.println(lotto.getNumbers());
    }

  }

  public static void printStatistics(List<Integer> rankStatistics) {
    System.out.println("3개 일치 (5,000원) - " + rankStatistics.get(0) + "개");
    System.out.println("4개 일치 (50,000원) - " + rankStatistics.get(1) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + rankStatistics.get(2) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankStatistics.get(3) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + rankStatistics.get(4) + "개");
  }
}