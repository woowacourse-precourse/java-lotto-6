package lotto.view;

import lotto.Lotto;
import lotto.domain.Member;
import lotto.domain.Rank;

import java.util.List;


public class OutputView {
    public static final String PURCHASE_RESULT_OUTPUT = "개를 구매했습니다.";
    public static final String STATISTIC_RESULT_OUTPUT = "당첨 통계";
    public static final String NEXT_LINE_OUTPUT = "---";

    public static void purchaseResult(Member member) {
        int purchasedCount = member.getPurchasedCount();
        println(purchasedCount + PURCHASE_RESULT_OUTPUT);

        member.getLottos().stream()
                .forEach(lotto -> printLotto(lotto));
    }
    public static void gameResult(List<Rank> ranks) {
        println(STATISTIC_RESULT_OUTPUT);
        println(NEXT_LINE_OUTPUT);

        for (Rank rank : Rank.getValidRanks(ranks)) {
            print(rank.getMessage());
            print(rank.getCount(ranks));
            print("개");
            System.out.println();
        }

    }

    private static void printLotto(final Lotto lotto) {
        System.out.println(lotto.getStringNumbers());
    }

    private static void println(String message) {
        System.out.println(message);
    }
    private static void print(String message) {
        System.out.print(message);
    }
    private static void print(int message) {
        System.out.print(message);
    }

}
