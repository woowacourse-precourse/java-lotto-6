package lotto.view;

import java.util.Arrays;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;

public class PrintView {

    private static final String NEWLINE = "\n";
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    private static void newLine() {
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printNumberOfLottos(int purchaseMoney) {
        int lottoNumber = purchaseMoney / 1000;
        System.out.printf("%d개를 구매했습니다", lottoNumber);
        newLine();
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        newLine();
    }

    public static void printStatistics(PrizeResult prizeResult, Rate rate) {
        System.out.println();
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.EMPTY))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + NEWLINE, rate.getRate());
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
