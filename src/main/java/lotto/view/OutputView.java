package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.WinningResult;

public class OutputView {

  private final static String PURCHASED_TICKET_ANNOUNCEMENT = "개를 구매했습니다.";
  private final static String WINNING_STATISTICS = "당첨 통계";

  public static void announceNumberOfPurchasedTickets(int lottoTicketQuantity) {
    System.out.println(lottoTicketQuantity + PURCHASED_TICKET_ANNOUNCEMENT);
  }

  public static void displayLottoNumbers(List<Integer> lottoNumber) {
    System.out.println(lottoNumber);
  }
  public static void printErrorMessage(String errorMessage){
    System.out.println(errorMessage);
  }

  public static void displayWinningStatistics() {
    System.out.println(WINNING_STATISTICS);
    System.out.println("---");
  }

  public static void resultList(Map<WinningResult, Integer> result) {

    for (WinningResult winningResult : WinningResult.values()) {
      Integer count = result.get(winningResult);
      if (count != null) {
        System.out.printf("%s%d개%n", winningResult.getMessage(), count);
      } else {
        System.out.printf("%s%d개%n", winningResult.getMessage(), 0);
      }
    }
  }

  public static void displayWinningStatistics(double profitRate) {
    System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
  }


}
