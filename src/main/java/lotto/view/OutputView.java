package lotto.view;

import lotto.domain.*;

public class OutputView {

    private static final String NEWLINE = "\n";
    private static final String CountOutputMsg = "개를 구매했습니다.";
    private static final String OutputTopMsg = "당첨 통계" + NEWLINE + "---";
    private static final String ResultOutputMsg = "%d개 일치 (%s원) - %d개";
    private static final String ResultBonusOutputMsg = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RateOutputMsg = "총 수익률은 %.1f%%입니다.";

    public static void outputCountMsg(Money money) {
        System.out.println(money.getLottoCount() + CountOutputMsg);
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto));
        System.out.println();
    }

    public static void outputResultMsg() {
        System.out.println(OutputTopMsg);
    }

    public static void printStatistics(PrizeResult prizeResult, Rate rate) {
        System.out.println(OutputTopMsg);
        for (Prize prize : Prize.values()) {
            if (!prize.equals(Prize.EMPTY)) {
                System.out.println(getPrintResultPrize(prize, prizeResult));
            }
        }
        System.out.printf((RateOutputMsg) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(Prize prize, PrizeResult prizeResult) {
        if (prize == Prize.SECOND) {
            return String.format(ResultBonusOutputMsg
                    , prize.getMatchLottoNumber()
                    , String.format("%,d", prize.getMoney())
                    , prizeResult.getPrizeCount(prize));
        }

        return String.format(ResultOutputMsg
                , prize.getMatchLottoNumber()
                , String.format("%,d", prize.getMoney())
                , prizeResult.getPrizeCount(prize));
    }
}
