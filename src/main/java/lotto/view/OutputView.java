package lotto.view;

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
        System.out.printf(SystemMessage.OUTPUT_PURCHASED_LOTTOS.getMessage(), purchasedLottos.getsize());
        purchasedLottos.stream()
                .map(Lotto::get)
                .forEach(System.out::println);
    }

    public static void printWinningStats(WinningStats winningStats) {
        printFrom(SystemMessage.OUTPUT_WINNING_STATS);
        winningStats.stream()
                .map(WinningStat::createMessage)
                .forEach(System.out::println);
    }

    public static void printProfitMargin(double profitMargin) {
        System.out.printf(SystemMessage.OUTPUT_PROFIT_MARGIN.getMessage(), getFormatStringFrom(profitMargin));
    }

    public static String getFormatStringFrom(double decimal) {
        String formatted = String.format("%,.2f", decimal);
        formatted = formatted.replaceAll(RegexConstant.TRAILING_ZEROS_FROM_DOUBLE.getRegex(),
                SystemMessage.EMPTY.getMessage());
        formatted = formatted.replaceAll(RegexConstant.LAST_DOTS.getRegex(),
                SystemMessage.EMPTY.getMessage());
        return formatted;
    }
}
