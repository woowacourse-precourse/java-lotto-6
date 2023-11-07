package lotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public void addWinningRank(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public double calculateEarningsRate(int inputMoney) {
        if (inputMoney == 0) {
            throw new ArithmeticException("입력 금액이 0입니다.");
        }
        long earnings = 0;
        for (Rank rank : Rank.values()) {
            earnings += getRankCount(rank) * rank.getReward();
        }
        return (double) earnings / inputMoney * 100;
    }

    public void printWinningResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMessage() + " - " + getRankCount(rank) + "개");
        }
    }
}
