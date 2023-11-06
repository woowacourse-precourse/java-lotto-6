package lotto.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputView {

    private static final String MESSAGE_NUMBER_OF_PURCHASED_LOTTOS = "%d개를 구매했습니다.";
    private static final String MESSAGE_RESULT_HEADER = "당첨 통계\n---";
    private static final String MESSAGE_RESULT_CONTENT = "%d개 일치 (%s원) - %d개";
    private static final String MESSAGE_RESULT_CONTENT_SECOND_PLACE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MESSAGE_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

    public static void printNumberOfPurchasedLottos(int numberOfPurchasedLottos) {
        System.out.println(String.format(MESSAGE_NUMBER_OF_PURCHASED_LOTTOS, numberOfPurchasedLottos));
    }

    public static void printGeneratedLottos(Lottos lottos) {
        lottos.lottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printStatistics(Map<Prize, Long> prizeResult) {
        System.out.println(MESSAGE_RESULT_HEADER);
        prizeResult.forEach(OutputView::printEachStatistics);
    }

    public static void printProfitRate(Double profitRate) {
        System.out.println(String.format(MESSAGE_PROFIT_RATE, profitRate));
    }

    private static void printEachStatistics(Prize prize, Long count) {
        if (prize == Prize.SECOND_PLACE) {
            printSecondPlaceStatistics(prize, count);
            return;
        }
        printCommonStatistics(prize, count);
    }

    private static void printCommonStatistics(Prize prize, Long count) {
        String formattedPrizeMoney = numberFormat.format(prize.getPrizeMoney());
        System.out.println(String.format(MESSAGE_RESULT_CONTENT,
                prize.getMatchCount(),
                formattedPrizeMoney,
                count));
    }

    private static void printSecondPlaceStatistics(Prize prize, Long count) {
        String formattedPrizeMoney = numberFormat.format(prize.getPrizeMoney());
        System.out.println(String.format(MESSAGE_RESULT_CONTENT_SECOND_PLACE,
                prize.getMatchCount(),
                formattedPrizeMoney,
                count));
    }


}
