package lotto.view.Output;

import java.util.Arrays;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.RateOfReturn;

public class OutputStatisticsView {
  private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + "\n" + "---";
  private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
  private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
  private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

  public static void printStatistics(PrizeResult prizeResult, RateOfReturn rateOfReturn) {
    System.out.println(OUTPUT_TOP_MESSAGE);
    Arrays.stream(Prize.values())
            .filter(prize -> !prize.equals(Prize.FAIL))
            .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
    System.out.printf((OUTPUT_RATE_OF_RETURN) + "\n", rateOfReturn.getRate());
  }

  private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
    if (prize == Prize.SECOND) {
      return String.format(OUTPUT_SECOND_RESULT_MESSAGE
              , prize.getMatchLottoNumber()
              , String.format("%,d", prize.getMoney())
              , prizeResult.getPrizeCount(prize));
    }

    return String.format(OUTPUT_RESULT_MESSAGE
            , prize.getMatchLottoNumber()
            , String.format("%,d", prize.getMoney())
            , prizeResult.getPrizeCount(prize));
  }
}