package lotto.view;

import java.util.Arrays;
import lotto.constants.Messages;
import java.text.DecimalFormat;
import lotto.constants.Values;
import lotto.constants.WinningCriteria;
import lotto.domain.WinningStatistics;

public class OutputView {

    public static void printPurchaseAmountPrompt() {
        System.out.println(Messages.PROMPT_PURCHASE_AMOUNT);
    }

    public static void printWinningNumbersPrompt() {
        System.out.println(Messages.PROMPT_WINNING_NUMBERS);
    }

    public static void printBonusNumberPrompt() {
        System.out.println(Messages.PROMPT_BONUS_NUMBER);
    }

    public static void printPurchaseLottoResult(String result) {
        System.out.println(result);
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(Messages.WINNING_STATISTICS + Messages.SEPARATOR_LINE);
        Arrays.stream(WinningCriteria.values())
                .filter(criteria -> criteria != WinningCriteria.LOSE)
                .forEach(criteria -> printWinningCriteria(criteria, winningStatistics));
    }

    private static void printWinningCriteria(WinningCriteria winningCriteria, WinningStatistics winningStatistics) {
        DecimalFormat decimalFormat = new DecimalFormat(Values.AMOUNT_DECIMAL_FORMAT);
        String formattedPrizeAmount = decimalFormat.format(winningCriteria.getPrizeAmount());
        String winningFormat = Messages.WINNING_MESSAGE;
        if (winningCriteria == WinningCriteria.SECOND) {
            winningFormat = Messages.WINNING_SECOND_MESSAGE;
        }
        String message = String.format(winningFormat, winningCriteria.getMatchingCount(), formattedPrizeAmount,
                winningStatistics.getWinningInfo().get(winningCriteria));
        System.out.println(message);
    }

    public static void printProFitPercentage(double profitPercentage) {
        System.out.println(String.format(Messages.TOTAL_PROFIT_MESSAGE, formatProfitRate(profitPercentage)));
    }

    private static String formatProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat(Values.PROFIT_DECIMAL_FORMAT);
        String formattedPercentage = decimalFormat.format(profitRate);
        formattedPercentage += Values.PROFIT_SYMBOL;
        return formattedPercentage;
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
