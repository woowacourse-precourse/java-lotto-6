package lotto.view;

import lotto.model.Lotto;
import lotto.model.PrizeRank;

import java.util.*;

public class ResultView {
    public void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayWinningStatistics(List<PrizeRank> prizeRanks) {
        System.out.println("\n당첨 통계\n---");

        Map<PrizeRank, Integer> countByRank = initializePrizeRankMap();

        for (PrizeRank rank : prizeRanks) {
            countByRank.put(rank, countByRank.getOrDefault(rank, 0) + 1);
        }

        // PrizeRank.values()는 Enum의 순서대로 반환하므로, 3등부터 1등 순으로 반복합니다.
        PrizeRank[] ranks = PrizeRank.values();
        Arrays.sort(ranks, Comparator.comparingInt(PrizeRank::getMatchingNumbers));

        for (PrizeRank rank : ranks) {
            if (rank != PrizeRank.NONE) {
                String message = getMessageForRank(rank);
                System.out.println(message + " - " + countByRank.get(rank) + "개");
            }
        }
    }

    private Map<PrizeRank, Integer> initializePrizeRankMap() {
        Map<PrizeRank, Integer> countByRank = new EnumMap<>(PrizeRank.class);
        for (PrizeRank rank : PrizeRank.values()) {
            countByRank.put(rank, 0);
        }
        return countByRank;
    }

    private String getMessageForRank(PrizeRank rank) {
        if (rank == PrizeRank.SECOND) {
            return rank.getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + rank.getPrizeMoney() + "원)";
        }
        return rank.getMatchingNumbers() + "개 일치 (" + rank.getPrizeMoney() + "원)";
    }

    public void displayRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    public void displayError(String errorMessage) {
        System.out.println("ERROR: " + errorMessage);
    }
}

