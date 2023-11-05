package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLottoCounts;

import java.util.List;

import static lotto.domain.Constants.*;

public class Output {

    public void printInputPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseQuantity(int lottoQuantity) {
        System.out.println();
        System.out.printf(QUANTITY_MESSAGE, lottoQuantity);
    }

    public void printMyLottos(List<Lotto> myLottos) {
        myLottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public void printInputWinningNumbersMessage() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printResult(WinningLottoCounts winningLottoCounts, double profit) {
        printWinningResultMessage();
        printWinningCounts(winningLottoCounts);
        printProfit(profit);
    }

    private static void printWinningResultMessage() {
        System.out.println();
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println(THREE_HYPHEN);
    }

    private static void printWinningCounts(WinningLottoCounts winningLottoCounts) {
        System.out.printf(WINNING_THREE_NUMBERS, winningLottoCounts.getCount(Rank.FIFTH.getRankIndex()));
        System.out.printf(WINNING_FOUR_NUMBERS, winningLottoCounts.getCount(Rank.FOURTH.getRankIndex()));
        System.out.printf(WINNING_FIVE_NUMBERS, winningLottoCounts.getCount(Rank.THIRD.getRankIndex()));
        System.out.printf(WINNING_FIVE_ADD_BONUS_NUMBERS, winningLottoCounts.getCount(Rank.SECOND.getRankIndex()));
        System.out.printf(WINNING_SIX_NUMBERS, winningLottoCounts.getCount(Rank.FIRST.getRankIndex()));
    }

    private static void printProfit(double profit) {
        System.out.printf(PROFIT, profit);
    }
}

