package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningYield;
import lotto.dto.Lottos;
import lotto.dto.Ranks;

import java.text.NumberFormat;

public class OutputView {
    public static void displayLottos(Lottos lottos) {
        System.out.println("\n" + lottos.getSize() + "개를 구매했습니다.");
        printLottos(lottos);
    }

    public static void displayWinningDetails(Ranks ranks, WinningYield winningYield) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printRankDetail(ranks);
        printYield(winningYield);
    }

    private static void printRankDetail(Ranks ranks) {
        // 출력 형식 요구사항을 위한 정렬
        Ranks reversedRanks = Ranks.getSortedRanks();

        for (Rank rank : reversedRanks.getRanks()) {
            if (rank == Rank.NONE) {
                continue;
            }
            System.out.println(rankMessage(rank, ranks.countMatches(rank)));
        }
    }

    private static String formatPrizeAmount(Rank rank) {
        return NumberFormat.getIntegerInstance().format(rank.getPrizeAmount());
    }

    private static String rankMessage(Rank rank, long count) {
        if (isSecondRank(rank)) {
            return rank.getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + formatPrizeAmount(rank) + "원) - " + count + "개";
        }
        return rank.getMatchingNumbers() + "개 일치 (" + formatPrizeAmount(rank) + "원) - " + count + "개";
    }

    private static boolean isSecondRank(Rank rank) {
        return rank == Rank.SECOND;
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printYield(WinningYield winningYield) {
        System.out.println("총 수익률은 " + winningYield.getYield() + "%입니다.");
    }
}
