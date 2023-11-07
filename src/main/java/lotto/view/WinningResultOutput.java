package lotto.view;

import lotto.domain.Rank;
import lotto.domain.RankCount;

public class WinningResultOutput {
    private static final int WINNING_FIFTH = 5_000;
    private static final int WINNING_FOURTH = 50_000;
    private static final int WINNING_THIRD = 1_500_000;
    private static final int WINNING_SECOND = 30_000_000;
    private static final int WINNING_FIRST = 2_000_000_000;

    public static void winningResult(RankCount rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + WINNING_FIFTH + "원) - " + rankCount.getRankCount().getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (" + WINNING_FOURTH + "원) - " + rankCount.getRankCount().getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (" + WINNING_THIRD + "원) - " + rankCount.getRankCount().getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + WINNING_SECOND + "원) - " + rankCount.getRankCount().getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (" + WINNING_FIRST + "원) - " + rankCount.getRankCount().getOrDefault(Rank.FIRST, 0) + "개");
    }
}