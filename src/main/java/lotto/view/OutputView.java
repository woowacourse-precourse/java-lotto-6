package lotto.view;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String MESSAGE_NUMBER_OF_PURCHASED_LOTTOS = NEW_LINE + "%d개를 구매했습니다.";
    private static final String MESSAGE_RESULT_HEADER = "당첨 통계" + NEW_LINE + "---";
    private static final String MESSAGE_RESULT_CONTENT = "%d개 일치 (%d원) - %d개";
    private static final String MESSAGE_RESULT_CONTENT_SECOND_PLACE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String MESSAGE_PROFIT_RATE = "총 수익률은 %f입니다.";

    public static void printNumberOfPurchasedLottos(int numberOfPurchasedLottos) {
        System.out.println(String.format(MESSAGE_NUMBER_OF_PURCHASED_LOTTOS, numberOfPurchasedLottos));
    }

    public static void printGeneratedLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println(NEW_LINE);
    }

    public static void printStatistics(Map<Prize, Long> prizeResult) {
        System.out.println(MESSAGE_RESULT_HEADER);
        prizeResult.forEach(OutputView::printEachStatistics);
    }

    public static void printProfitRate(Double profitRate) {
        System.out.println(String.format(MESSAGE_PROFIT_RATE, profitRate));
    }

    private static void printEachStatistics(Prize prize, Long count) {
        System.out.println(NEW_LINE);
        if (prize == Prize.SECOND_PLACE) {
            printSecondPlaceStatistics(prize, count);
            return;
        }
        printCommonStatistics(prize, count);
    }

    private static void printCommonStatistics(Prize prize, Long count) {
        System.out.println(String.format(MESSAGE_RESULT_CONTENT,
                prize.getMatchCount(),
                prize.getPrizeMoney(),
                count));
    }

    private static void printSecondPlaceStatistics(Prize prize, Long count) {
        System.out.println(String.format(MESSAGE_RESULT_CONTENT_SECOND_PLACE,
                prize.getMatchCount(),
                prize.getPrizeMoney(),
                count));
    }


}
