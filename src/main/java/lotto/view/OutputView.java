package lotto.view;

import static lotto.message.ViewMessage.OUTPUT_MATCH_COUNT;
import static lotto.message.ViewMessage.OUTPUT_PROFIT_RATE;
import static lotto.message.ViewMessage.OUTPUT_PURCHASE_COUNT;
import static lotto.message.ViewMessage.OUTPUT_RESULT_HEADER;
import static lotto.message.ViewMessage.PROFIT_FORMAT;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.ResultSheet;
import lotto.message.ExceptionMessage;

public class OutputView {
    public static final String LOTTO_NUMBER_DELIMITER = ", ";
    public static final String PRINT_LOTTO_FORMAT = "[%s]\n";

    public static void printLottos(Lottos purchasedLotto) {
        System.out.printf(OUTPUT_PURCHASE_COUNT, purchasedLotto.size());
        List<Lotto> lottos = purchasedLotto.lottoItems();
        lottos.forEach(OutputView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        String listString = lotto.numbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
        System.out.printf(PRINT_LOTTO_FORMAT, listString);
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println(ExceptionMessage.PREFIX + e.getMessage());
    }

    public static void printResult(ResultSheet sheet) {
        printResultHeader();
        printByRank(Rank.FIFTH, sheet.findCountByRank(Rank.FIFTH));
        printByRank(Rank.FOURTH, sheet.findCountByRank(Rank.FOURTH));
        printByRank(Rank.THIRD, sheet.findCountByRank(Rank.THIRD));
        printByRank(Rank.SECOND, sheet.findCountByRank(Rank.SECOND));
        printByRank(Rank.FIRST, sheet.findCountByRank(Rank.FIRST));
        printProfitRate(sheet);
    }

    private static void printResultHeader() {
        System.out.println(OUTPUT_RESULT_HEADER);
    }

    private static void printByRank(Rank rank, int count) {
        System.out.printf(OUTPUT_MATCH_COUNT, rank.getMessage(), count);
    }

    private static void printProfitRate(ResultSheet sheet) {
        double totalProfit = sheet.getTotalProfit();
        System.out.printf(OUTPUT_PROFIT_RATE, PROFIT_FORMAT.format(totalProfit));
    }
}
