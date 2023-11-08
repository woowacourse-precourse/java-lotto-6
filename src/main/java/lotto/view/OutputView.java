package lotto.view;

import lotto.domain.*;

public class OutputView {

    private static final String NEWLINE = "\n";
    private static final String COUNT_OUTPUT_MSG = "개를 구매했습니다.";
    private static final String OUTPUT_TOP_MSG = "당첨 통계" + NEWLINE + "---";
    private static final String RESULT_OUTPUT_MSG = "%d개 일치 (%s원) - %d개";
    private static final String RESULT_BONUS_OUTPUT_MSG = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OUTPUT_MSG = "총 수익률은 %.1f%%입니다.";

    public static void outputCountMsg(Money money) {
        System.out.println(money.getLottoCount() + COUNT_OUTPUT_MSG);
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto));
        System.out.println();
    }

    public static void outputResultMsg() {
        System.out.println(OUTPUT_TOP_MSG);
    }

    public static void printStatistics(PrizeResult prizeResult, Rate rate) {
        System.out.println(OUTPUT_TOP_MSG);
        for (Prize prize : Prize.values()) {
            if (!prize.equals(Prize.EMPTY)) {
                System.out.println(getPrintResultPrize(prize, prizeResult));
            }
        }
        System.out.printf((RATE_OUTPUT_MSG) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
        if (prize == Prize.SECOND) {
            return String.format(RESULT_BONUS_OUTPUT_MSG
                    , prize.getMatchLottoNumber()
                    , String.format("%,d", prize.getMoney())
                    , prizeResult.getPrizeCount(prize));
        }

        return String.format(RESULT_OUTPUT_MSG
                , prize.getMatchLottoNumber()
                , String.format("%,d", prize.getMoney())
                , prizeResult.getPrizeCount(prize));
    }
}
