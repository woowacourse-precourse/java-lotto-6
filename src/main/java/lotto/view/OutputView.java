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

    public static void gameResult(List<Rank> ranks,Member member) {
        println(STATISTIC_RESULT_OUTPUT);
        println(NEXT_LINE_OUTPUT);

        for (Rank rank : Rank.values()) {
            println(rank.getMessage() + rank.getCount(ranks) +"개");
        }
        System.out.println("총 수익률은 " +
                String.format("%,.1f", calcEarnRate(sumEarnMoney(ranks), member.getPurchasedPrice())) + "%입니다.");
    }
    private static int sumEarnMoney(List<Rank> ranks) {
        return ranks.stream()
                .mapToInt(rank -> rank.getPrize())
                .sum();
    }

    private static double calcEarnRate(int earn, int purchasedMoney) {
        return (double) (earn * 100) / purchasedMoney;
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
