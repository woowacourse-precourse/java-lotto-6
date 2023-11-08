package lotto.view;

import java.util.List;
import lotto.controller.LotteryHost;
import lotto.model.Lotto;

public class Output {

  public static void print(String s) {
    System.out.println(s);
  }

  public static void printLottoNumbersAndQuantity(List<Lotto> lottoTickets) {
    System.out.println(lottoTickets.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottoTickets) {
      printLottoNumbers(lotto);
    }
  }

  private static void printLottoNumbers(Lotto lotto) {
    int lottoSize = lotto.getNumbers().size();
    String lottoNumberOutput = "[";
    for (int i = 0; i < lottoSize; i++) {
      lottoNumberOutput += lotto.getNumbers().get(i);
      if (isIndexInRange(i, lottoSize)) {
        lottoNumberOutput += ", ";
      }
    }
    lottoNumberOutput += "]";
    System.out.println(lottoNumberOutput);
  }

  private static boolean isIndexInRange(int index, int range) {
    return index < range - 1;
  }

  public static void printResult(LotteryHost lotteryhost, int numberOfLottery) {
    System.out.println("3개 일치 (5,000원) - " + lotteryhost.getResult()[0] + "개\n" +
        "4개 일치 (50,000원) - " + lotteryhost.getResult()[1] + "개\n" +
        "5개 일치 (1,500,000원) - " + lotteryhost.getResult()[2] + "개\n" +
        "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lotteryhost.getResult()[3] + "개\n" +
        "6개 일치 (2,000,000,000원) - " + lotteryhost.getResult()[4] + "개\n" +
        "총 수익률은 " + lotteryhost.calculateRate(numberOfLottery) + "%입니다.");
  }
}
