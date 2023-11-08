package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.rank.domain.Rank;
import lotto.rank.domain.RankCount;
import lotto.userLotto.domain.Lotto;
import lotto.userLotto.domain.Lottos;

public class OutputView {
    private static final String BUY_COUNT = "개를 구매했습니다.";
    private static final String WINNING_RESULT ="당첨 통계";
    private static final String LINE ="---";

    public static void printLottoCount(int count){
        System.out.println(count + BUY_COUNT);

    }


    public static void printLottos(Lottos lottos){
        List<Lotto> lottos1 = lottos.getLottos();
        for (Lotto lotto : lottos1){
            System.out.println(lotto.getLotto());
        }
    }
    // OutputView 클래스 내의 메서드 수정
    public static void printResultRankStatistics(RankCount rankCount) {
        Map<Rank, Integer> unmodifiableCountMap = rankCount.getUnmodifiableRankCount();

        StringBuilder result = new StringBuilder(WINNING_RESULT + "\n" + LINE + "\n");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                result.append(String.format("%s (%,d원) - %d개\n",
                        rank.getMessage(),
                        rank.getWinningMoney(),
                        unmodifiableCountMap.getOrDefault(rank, 0)));
            }
        }
        System.out.print(result);
    }

    public static void printRevenueRate(double revenueRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenueRate);
    }


}
