package lotto.view;

import lotto.constants.Messages;

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

    public static void printResult(String winningResult, String profitPercentage) {
        System.out.println(winningResult);
        System.out.println(String.format(Messages.TOTAL_PROFIT_MESSAGE, profitPercentage));
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
