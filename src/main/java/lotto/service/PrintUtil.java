package lotto.service;


import lotto.constant.DrawMessage;

public class PrintUtil {
    DrawMessage drawMessage;

    public void printPurchaseAmountInput() {
        System.out.println(drawMessage.ENTER_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void printNumberOfLotto(int number) {
        System.out.printf(drawMessage.PURCHASE_COUNT_MESSAGE.getMessage(), number);
    }
    public void printLottoNumbers(StringBuilder output) {
        System.out.println(output);
    }

    public void printWinnerNumbersInput() {
        System.out.println(drawMessage.ENTER_WINNER_NUMBERS_MESSAGE.getMessage());
    }

    public void printBonusNumberInput() {
        System.out.println(drawMessage.ENTER_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printWinnerStatistics() {
        System.out.println(drawMessage.WINNING_STATISTICS_MESSAGE.getMessage());
    }

    public void printProfit(String totalProfit) {
        totalProfit += "%";
        System.out.printf(drawMessage.TOTAL_PROFIT_MESSAGE.getMessage(), totalProfit);
    }
}
