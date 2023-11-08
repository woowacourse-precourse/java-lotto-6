package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.UserLotto;

import java.util.List;

public class OutputView {

    public static void printPurchaseLotto() {
        System.out.println(Messages.ENTER_PURCHASE_AMOUNT);
    }

    public static void printPurchaseLottoCount(int count) {
        System.out.println(String.format(Messages.PURCHASE_COUNT_MESSAGE, count));
    }

    

    public static void printWinningLotto() {
        System.out.println(Messages.LOTTO_NUMBERS_HEADER);
    }

    public static void printBonusNumber() {
        System.out.println(Messages.BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoPrizeHeader() {
        System.out.println(Messages.WINNING_STATISTICS_HEADER);
    }
    public static void printLottoPrize(String description, String prize, int count) {
        System.out.println(String.format(Messages.WINNING_MESSAGE_FORMAT, description, prize, count));
    }

    public static void printProfit(Double profit) {
        System.out.println(String.format(Messages.TOTAL_PROFIT_MESSAGE_FORMAT, profit));
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printLottos(UserLotto userLottos) {
        for (Lotto lotto: userLottos.getUserLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningResults(long firstPrizeCount, long secondPrizeCount, long thirdPrizeCount, long fourthPrizeCount, long fifthPrizeCount) {
        printLottoPrize(Rank.THIRD.getDescription(), Rank.THIRD.getPrize(), (int) thirdPrizeCount);
        printLottoPrize(Rank.FOURTH.getDescription(), Rank.FOURTH.getPrize(), (int) fourthPrizeCount);
        printLottoPrize(Rank.FIFTH.getDescription(), Rank.FIFTH.getPrize(), (int) fifthPrizeCount);
        printLottoPrize(Rank.SECOND.getDescription(), Rank.SECOND.getPrize(), (int) secondPrizeCount);
        printLottoPrize(Rank.FIRST.getDescription(), Rank.FIRST.getPrize(), (int) firstPrizeCount);
    }
}
