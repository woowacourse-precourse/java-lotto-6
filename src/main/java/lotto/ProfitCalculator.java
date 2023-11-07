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

    public Double calculateProfitRate(Map<Integer, Integer> winningStatistics, String buying) {
        Double prizeAmount = calculatePrizeAmount(winningStatistics);
        Double buyingAmount = Double.parseDouble(buying);
        return prizeAmount / buyingAmount * 100;
    }

    private Double calculatePrizeAmount(Map<Integer, Integer> winningStatistics) {
        Double prizeAmount = 0.0;
        prizeAmount += winningStatistics.get(6) * Prize.FIRST.getPrize();
        prizeAmount += winningStatistics.get(2) * Prize.SECOND.getPrize();
        prizeAmount += winningStatistics.get(5) * Prize.THIRD.getPrize();
        prizeAmount += winningStatistics.get(4) * Prize.FOURTH.getPrize();
        prizeAmount += winningStatistics.get(3) * Prize.FIFTH.getPrize();

        return prizeAmount;
    }
}
