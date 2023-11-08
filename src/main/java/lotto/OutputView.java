package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
  public void printTickets(List<Lotto> lottoList) {
    for (Lotto lotto : lottoList) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void printWinnings() {
    System.out.println("당첨 통계\n---");
  }
}
