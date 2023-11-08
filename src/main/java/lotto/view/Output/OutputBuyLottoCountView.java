package lotto.view.Output;

import lotto.domain.Money;

public class OutputBuyLottoCountView {
  private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

  public static void printBuyLotto(Money money) {
    System.out.printf((OUTPUT_MESSAGE) + "%n", money.getTicket());
  }
}