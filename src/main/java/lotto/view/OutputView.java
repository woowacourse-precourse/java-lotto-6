package lotto.view;

import static lotto.constants.Notice.PURCHASE_RESULT;
import static lotto.constants.Notice.WINNER_RESULT;
import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.SameNumber;

public class OutputView {
    private static final String UNIT = "개";
    private static List<SameNumber> sameNumbers;

    public static void printPurchaseResult(List<Lotto> lottos) {
        int quantity = lottos.size();
        System.out.println();
        System.out.println(quantity + PURCHASE_RESULT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinnerResult(List<SameNumber> sameNumbers) {
        OutputView.sameNumbers = sameNumbers;
        System.out.println();
        System.out.println(WINNER_RESULT.getMessage());
        System.out.println(FIFTH.getMessage() + countFifth() + UNIT);
        System.out.println(FOURTH.getMessage() + countFourth() + UNIT);
        System.out.println(THIRD.getMessage() + countThird() + UNIT);
        System.out.println(SECOND.getMessage() + countSecond() + UNIT);
        System.out.println(FIRST.getMessage() + countFirst() + UNIT);
    }

    private static int countFirst() {
        return (int) sameNumbers.stream()
                .filter(sameNumber -> sameNumber.getCount() == 6)
                .count();
    }

    private static int countSecond() {
        return (int) sameNumbers.stream()
                .filter(sameNumber -> sameNumber.getCount() == 5 && sameNumber.hasBonusNumber())
                .count();
    }

    private static int countThird() {
        return (int) sameNumbers.stream()
                .filter(sameNumber -> sameNumber.getCount() == 5 && !sameNumber.hasBonusNumber())
                .count();
    }

    private static int countFourth() {
        return (int) sameNumbers.stream()
                .filter(sameNumber -> sameNumber.getCount() == 4)
                .count();
    }

    private static int countFifth() {
        return (int) sameNumbers.stream()
                .filter(sameNumber -> sameNumber.getCount() == 3)
                .count();
    }
}
