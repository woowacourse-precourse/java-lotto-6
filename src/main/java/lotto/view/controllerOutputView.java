package lotto.view;

import lotto.domain.PrizeMoney;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;

import java.util.Arrays;

public class controllerOutputView {
    private static final String NEWLINE = "\n";
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printStatistics(PrizeResult prizeResult, Rate rate) {
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(PrizeMoney.values())
                .filter(prizeMoney -> !prizeMoney.equals(PrizeMoney.EMPTY))
                .forEach(prizeMoney -> System.out.println(getPrintResultPrize(prizeMoney, prizeResult)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(PrizeMoney prizeMoney, PrizeResult prizeResult) {
        if (prizeMoney == PrizeMoney.SECOND) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE
                    , prizeMoney.getRightLottoNumber()
                    , String.format("%,d", prizeMoney.getMoney())
                    , prizeResult.getPrizeCount(prizeMoney));
        }

        return String.format(OUTPUT_RESULT_MESSAGE
                , prizeMoney.getRightLottoNumber()
                , String.format("%,d", prizeMoney.getMoney())
                , prizeResult.getPrizeCount(prizeMoney));
    }
}
