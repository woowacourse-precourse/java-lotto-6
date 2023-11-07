package view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Rank;
import message.InputMessage;
import message.OutputMessage;
import message.Symbol;

public class OutputView {

    public static void printPurchaseAmountInputMessage() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printPurchasedLotteryNumbers(List<Lotto> lotteries) {
        StringBuilder message = new StringBuilder();
        message.append(lotteries.size()).append(OutputMessage.PURCHASE_FINISHED_MESSAGE.getMessage())
                .append(Symbol.NEXT_LINE.getSymbol());
        for (Lotto lottery : lotteries) {
            message.append(lottery.toString()).append(Symbol.NEXT_LINE.getSymbol());
        }
        System.out.println(message);
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(InputMessage.WINNING_NUMBERS_MESSAGE.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void printResultStatistics(Map<Rank, Integer> result) {
        System.out.println(OutputMessage.STATISTICS_HEADER_MESSAGE.getMessage());
        for (Rank rank : Rank.values()) {
            System.out.println(generateStatisticalMessage(rank, result.get(rank)));
        }
    }

    private static String generateStatisticalMessage(Rank rank, int count) {
        StringBuilder printMessage = new StringBuilder();
        printMessage.append(rank.getMatchCount()).append(OutputMessage.MATCHED_COUNT_MESSAGE.getMessage());
        if (rank.isBonusNeeded()) {
            printMessage.append(OutputMessage.BONUS_NUMBER_MATCH_MESSAGE.getMessage());
        }
        printMessage.append(Symbol.SPACE.getSymbol()).append(Symbol.OPEN_BRACKET.getSymbol());
        DecimalFormat decimalFormat = new DecimalFormat(Symbol.DECIMAL_PATTERN.getSymbol());
        printMessage.append(decimalFormat.format(rank.getPrize())).append(Symbol.WON.getSymbol())
                .append(Symbol.CLOSE_BRACKET.getSymbol()).append(Symbol.SPACE.getSymbol())
                .append(Symbol.DASH.getSymbol()).append(Symbol.SPACE.getSymbol())
                .append(count).append(Symbol.COUNT.getSymbol());
        return printMessage.toString();
    }
}
