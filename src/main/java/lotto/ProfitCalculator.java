package lotto;

import java.util.Map;

public class ProfitCalculator {
    private enum Prize {
        FIRST(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);

        private final int prize;

        Prize(int prize) {
            this.prize = prize;
        }

        public int getPrize() {
            return prize;
        }
    }

    private enum Rank {
        FIRST(6), SECOND(2), THIRD(5), FOURTH(4), FIFTH(3);

        private final int rank;

        Rank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }
    }

    public Double calculateProfitRate(Map<Integer, Integer> winningStatistics, String buying) {
        Double prizeAmount = calculatePrizeAmount(winningStatistics);
        Double buyingAmount = Double.parseDouble(buying);
        return prizeAmount / buyingAmount * 100;
    }

    //전체 상금 계산
    private Double calculatePrizeAmount(Map<Integer, Integer> winningStatistics) {
        Double prizeAmount = 0.0;
        prizeAmount += winningStatistics.get(Rank.FIRST.getRank()) * Prize.FIRST.getPrize();
        prizeAmount += winningStatistics.get(Rank.SECOND.getRank()) * Prize.SECOND.getPrize();
        prizeAmount += winningStatistics.get(Rank.THIRD.getRank()) * Prize.THIRD.getPrize();
        prizeAmount += winningStatistics.get(Rank.FOURTH.getRank()) * Prize.FOURTH.getPrize();
        prizeAmount += winningStatistics.get(Rank.FIFTH.getRank()) * Prize.FIFTH.getPrize();

        return prizeAmount;
    }
}
