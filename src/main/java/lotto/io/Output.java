package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLottos;

import java.util.List;

import static lotto.io.IoConstants.*;

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

    public void printResult(WinningLottos winningLottos, double profit) {
        printWinningResultMessage();
        printWinningCounts(winningLottos);
        printProfit(profit);
    }

    private static void printWinningResultMessage() {
        System.out.println();
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println(THREE_HYPHEN);
    }

    private static void printWinningCounts(WinningLottos winningLottos) {
        System.out.printf(WINNING_THREE_NUMBERS, winningLottos.getCount(Rank.FIFTH.getRankIndex()));
        System.out.printf(WINNING_FOUR_NUMBERS, winningLottos.getCount(Rank.FOURTH.getRankIndex()));
        System.out.printf(WINNING_FIVE_NUMBERS, winningLottos.getCount(Rank.THIRD.getRankIndex()));
        System.out.printf(WINNING_FIVE_ADD_BONUS_NUMBERS, winningLottos.getCount(Rank.SECOND.getRankIndex()));
        System.out.printf(WINNING_SIX_NUMBERS, winningLottos.getCount(Rank.FIRST.getRankIndex()));
    }

    private static void printProfit(double profit) {
        System.out.printf(PROFIT, profit);
    }
}

