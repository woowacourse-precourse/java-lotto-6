package lotto.view;

import java.util.Arrays;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;

public class OutputResultView {
    private static final String NEWLINE = "\n";
    private static final String OUTPUT_FIRST_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String OUTPUT_RESULT_MESSAGE_1 = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_RESULT_MESSAGE_2 = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RETURN_RATE = "총 수익률은 %.1f%%입니다.";

    public static void printResult(PrizeResult prizeResult, Rate rate) {
        System.out.println(OUTPUT_FIRST_MESSAGE);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.EMPTY))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
        System.out.printf((OUTPUT_RETURN_RATE) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
        if (prize == Prize.SECOND) {
            return String.format(OUTPUT_RESULT_MESSAGE_2
                    , prize.getMatchLottoCount()
                    , String.format("%,d", prize.getMoney())
                    , prizeResult.getPrizeCount(prize));
        }
        return  String.format(OUTPUT_RESULT_MESSAGE_1
                , prize.getMatchLottoCount()
                , String.format("%,d", prize.getMoney())
                , prizeResult.getPrizeCount(prize));
    }
}
