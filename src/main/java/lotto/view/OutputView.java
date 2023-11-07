package lotto.view;

import static lotto.message.ViewMessage.OUTPUT_MATCH_COUNT;
import static lotto.message.ViewMessage.OUTPUT_PROFIT_RATE;
import static lotto.message.ViewMessage.OUTPUT_PURCHASE_COUNT;
import static lotto.message.ViewMessage.OUTPUT_RESULT_HEADER;
import static lotto.message.ViewMessage.PROFIT_FORMAT;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.ResultSheet;
import lotto.message.ExceptionMessage;

public class OutputView {
    public static void printLottos(Lottos purchasedLotto) {
        System.out.printf(OUTPUT_PURCHASE_COUNT, purchasedLotto.getCount());
        System.out.println(purchasedLotto.getLottosNumber());
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
