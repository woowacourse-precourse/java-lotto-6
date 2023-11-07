package lotto.view;

import lotto.domain.Rank;
import lotto.domain.RankCount;

public class WinningResultOutput {
    public static void winningResult(RankCount rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCount.getRankCount().getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.getRankCount().getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.getRankCount().getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.getRankCount().getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.getRankCount().getOrDefault(Rank.FIRST, 0) + "개");
    }
}
