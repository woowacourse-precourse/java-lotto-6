package lotto.service;


import lotto.constant.DrawMessage;

public class PrintUtil {

    public void printPurchaseAmountInput() {
        System.out.println(DrawMessage.ENTER_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void printNumberOfLotto(int number) {
        System.out.printf(DrawMessage.PURCHASE_COUNT_MESSAGE.getMessage(), number);
    }

    public void printLottoNumbers(StringBuilder output) {
        System.out.println(output);
    }

    public void printWinnerNumbersInput() {
        System.out.println(DrawMessage.ENTER_WINNER_NUMBERS_MESSAGE.getMessage());
    }

    public void printBonusNumberInput() {
        System.out.println(DrawMessage.ENTER_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printWinnerStatistics() {
        System.out.print(DrawMessage.WINNING_STATISTICS_MESSAGE.getMessage());
    }

    public void printLottoStatisticsResults(StringBuilder result) {
        System.out.println(result);
    }

    public void printProfit(String totalProfit) {
        System.out.printf(DrawMessage.TOTAL_PROFIT_MESSAGE.getMessage(), totalProfit + "%");
    }
}
