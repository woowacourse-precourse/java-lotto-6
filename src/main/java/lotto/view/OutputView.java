package lotto.view;

import static lotto.constants.Notice.PROFIT_RATE;
import static lotto.constants.Notice.PURCHASE_RESULT;
import static lotto.constants.Notice.WINNER_RESULT;
import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.SameNumberCount;

public class OutputView {
    private static final String UNIT = "개";
    private static List<SameNumberCount> sameNumberCounts;

    public static void printPurchaseResult(List<Lotto> lottos) {
        int quantity = lottos.size();
        System.out.println();
        System.out.println(quantity + PURCHASE_RESULT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinnerResult(List<SameNumberCount> sameNumberCounts) {
        OutputView.sameNumberCounts = sameNumberCounts;
        System.out.println();
        System.out.println(WINNER_RESULT.getMessage());
        System.out.println(FIFTH.getMessage() + countFifth() + UNIT);
        System.out.println(FOURTH.getMessage() + countFourth() + UNIT);
        System.out.println(THIRD.getMessage() + countThird() + UNIT);
        System.out.println(SECOND.getMessage() + countSecond() + UNIT);
        System.out.println(FIRST.getMessage() + countFirst() + UNIT);
    }

    public static void printProfitRate(int purchaseAmount) {
        System.out.printf(PROFIT_RATE.getMessage(), calculateProfitRate(purchaseAmount));
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    private static int calculateProfit() {
        return countFirst() * FIRST.getPrize()
                + countSecond() * SECOND.getPrize()
                + countThird() * THIRD.getPrize()
                + countFourth() * FOURTH.getPrize()
                + countFifth() * FIFTH.getPrize();
    }

    private static double calculateProfitRate(int purchaseAmount) {
        return calculateProfit() * 100.0 / purchaseAmount;
    }

    private static int countFirst() {
        return (int) sameNumberCounts.stream()
                .filter(sameNumberCount -> sameNumberCount.getCount() == 6)
                .count();
    }

    private static int countSecond() {
        return (int) sameNumberCounts.stream()
                .filter(sameNumberCount -> sameNumberCount.getCount() == 5 && sameNumberCount.hasBonusNumber())
                .count();
    }

    private static int countThird() {
        return (int) sameNumberCounts.stream()
                .filter(sameNumberCount -> sameNumberCount.getCount() == 5 && !sameNumberCount.hasBonusNumber())
                .count();
    }

    private static int countFourth() {
        return (int) sameNumberCounts.stream()
                .filter(sameNumberCount -> sameNumberCount.getCount() == 4)
                .count();
    }

    private static int countFifth() {
        return (int) sameNumberCounts.stream()
                .filter(sameNumberCount -> sameNumberCount.getCount() == 3)
                .count();
    }
}
