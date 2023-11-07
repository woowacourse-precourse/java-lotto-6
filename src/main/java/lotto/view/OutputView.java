package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningYield;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void displayLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        printLottos(lottos);
    }

    public static void displayWinningDetails(List<Rank> ranks, WinningYield winningYield) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printRankDetail(ranks);
        printYield(winningYield);
    }

    private static void printRankDetail(List<Rank> ranks) {
        // 출력 형식 요구사항을 위한 정렬
        List<Rank> reversedRanks = sortRank();

        for (Rank rank : reversedRanks) {
            if (rank == Rank.NONE) {
                continue;
            }
            long count = countMatches(ranks, rank);
            System.out.println(rankMessage(rank, count));
        }
    }

    private static long countMatches(List<Rank> ranks, Rank rank) {
        return ranks.stream().filter(r -> r == rank).count();
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

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printYield(WinningYield winningYield) {
        System.out.println("총 수익률은 " + winningYield.getYield() + "%입니다.");
    }

    private static List<Rank> sortRank() {
        List<Rank> reversedRanks = new ArrayList<>(Arrays.asList(Rank.values()));
        Collections.reverse(reversedRanks);
        return reversedRanks;
    }
}
