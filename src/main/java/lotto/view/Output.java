package lotto.view;

import static lotto.message.Message.*;

public class Output {
    public static void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS.message());
        System.out.println(SEPARATOR.message());
    }

    public static void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT.message());
    }

    public static void printPurchaseLottoQuantityMessage(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER.message());
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER.message());
    }

    public static void printProfitPercentage(int profitPercentage) {
        System.out.println("총 수익률은 " + profitPercentage + "입니다.");
    }
}
