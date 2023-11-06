package lotto.view;

import lotto.constants.Messages;
import java.text.DecimalFormat;
import lotto.constants.Values;

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

    public static void printResult(String winningResult, double profitPercentage) {
        System.out.println(winningResult);
        System.out.println(String.format(Messages.TOTAL_PROFIT_MESSAGE, getProfitPercentage(profitPercentage)));
    }

    public static String getProfitPercentage(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat(Values.PROFIT_DECIMAL_FORMAT);
        String formattedPercentage = decimalFormat.format(profitRate);
        formattedPercentage += Values.PROFIT_SYMBOL;
        return formattedPercentage;
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
