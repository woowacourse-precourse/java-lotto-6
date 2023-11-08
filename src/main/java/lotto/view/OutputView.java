package lotto.view;

import static java.util.Comparator.comparingInt;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningStat;
import lotto.domain.WinningStats;
import lotto.system.RegexConstant;
import lotto.system.SystemMessage;

public class OutputView {
    public static void exceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printFrom(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        System.out.printf(SystemMessage.OUTPUT_PURCHASED_LOTTOS.getMessage(), purchasedLottos.getSize());
        purchasedLottos.stream()
                .map(Lotto::getToIntegerList)
                .forEach(System.out::println);
    }

    public static void printWinningStats(WinningStats winningStats) {
        printFrom(SystemMessage.OUTPUT_WINNING_STATS);
        winningStats.stream()
                .sorted(comparingInt(WinningStat::getRank).reversed())
                .map(WinningStat::createMessage)
                .forEach(System.out::println);
    }

    public static void printProfitMargin(double profitMargin) {
        System.out.printf(SystemMessage.OUTPUT_PROFIT_MARGIN.getMessage(), getFormatStringFrom(profitMargin));
    }

    public static String getFormatStringFrom(double decimal) {
        String formatted = String.format(RegexConstant.DECIMAL_FORMAT.getRegex(), decimal);
        formatted = getRemovedTrailingZero(formatted);
        formatted = getRemovedLastDot(formatted);
        return formatted;
    }

    private static String getRemovedTrailingZero(String formatted) {
        return formatted.replaceAll(RegexConstant.TRAILING_ZEROS_FROM_DOUBLE.getRegex(),
                SystemMessage.EMPTY.getMessage());
    }

    private static String getRemovedLastDot(String formatted) {
        return formatted.replaceAll(RegexConstant.LAST_DOT.getRegex(),
                SystemMessage.EMPTY.getMessage());
    }
}
