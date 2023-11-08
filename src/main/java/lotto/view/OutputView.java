package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
  public static final String TICKET_NUMBER = "개를 구매했습니다.";
  public static final String RESULT_START = "당첨 통계\n"
          + "---";
  public static final String RESULT_5 = "3개 일치 (5,000원) - ";
  public static final String RESULT_4 = "4개 일치 (50,000원) - ";
  public static final String RESULT_3 = "5개 일치 (1,500,000원) - ";
  public static final String RESULT_2 = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
  public static final String RESULT_1 = "6개 일치 (2,000,000,000원) - ";
  public static final String RESULT_RATE_START = "총 수익률은 ";
  public static final String RESULT_RATE_END = "%입니다.";


  public static void printTicketNumber(int ticket) {
    System.out.println(ticket + TICKET_NUMBER);
  }

  public void printLottoList(int ticket, List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      System.out.print(lotto);
    }
  }

  public static void printPrizeResult(int[] results) {
    System.out.println(RESULT_START);
    System.out.println(RESULT_5 + results[4] + "개");
    System.out.println(RESULT_4 + results[3] + "개");
    System.out.println(RESULT_3 + results[2] + "개");
    System.out.println(RESULT_2 + results[1] + "개");
    System.out.println(RESULT_1 + results[0] + "개");
  }

  public static void printRate(double rate) {
    String roundedRate = String.format("%.2f", rate);
    System.out.println(RESULT_RATE_START + roundedRate + RESULT_RATE_END);
  }

}
