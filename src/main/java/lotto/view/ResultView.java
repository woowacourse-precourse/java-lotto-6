package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;

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

        PrizeRank[] orderedRanks = {
                PrizeRank.FIFTH,  // 3개 일치
                PrizeRank.FOURTH, // 4개 일치
                PrizeRank.THIRD,  // 5개 일치
                PrizeRank.SECOND, // 5개 일치, 보너스 볼 일치
                PrizeRank.FIRST   // 6개 일치
        };

        for (PrizeRank rank : orderedRanks) {
            String prizeMoneyFormatted = String.format("%,d", rank.getPrizeMoney());
            String message = rank.getMatchingNumbers() + "개 일치 (" + prizeMoneyFormatted + "원)";
            if (rank == PrizeRank.SECOND) {
                message = "5개 일치, 보너스 볼 일치 (" + prizeMoneyFormatted + "원)";
            }
            System.out.println(message + " - " + countByRank.get(rank) + "개");
        }
    }

    private Map<PrizeRank, Integer> initializePrizeRankMap() {
        Map<PrizeRank, Integer> countByRank = new EnumMap<>(PrizeRank.class);
        for (PrizeRank rank : PrizeRank.values()) {
            countByRank.put(rank, 0);
        }
        return countByRank;
    }

    public void displayRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    public void displayError(String errorMessage) {
        System.out.println("ERROR: " + errorMessage);
    }
}

