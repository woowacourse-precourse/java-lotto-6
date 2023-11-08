package lotto.view;

import lotto.config.Constant;
import lotto.domain.Rank;
import lotto.domain.RankCount;

import java.text.DecimalFormat;

public class WinningResultOutput {

    public static void winningResult(RankCount rankCount) {
        DecimalFormat df = new DecimalFormat("#,###");

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + df.format(Constant.WINNING_FIFTH) + "원) - " + rankCount.getRankCount()
                .getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (" + df.format(Constant.WINNING_FOURTH) + "원) - " + rankCount.getRankCount()
                .getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (" + df.format(Constant.WINNING_THIRD) + "원) - " + rankCount.getRankCount()
                .getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(Constant.WINNING_SECOND) + "원) - " + rankCount.getRankCount()
                .getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (" + df.format(Constant.WINNING_FIRST) + "원) - " + rankCount.getRankCount()
                .getOrDefault(Rank.FIRST, 0) + "개");
    }
}