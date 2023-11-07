package lotto;

import java.util.List;
import java.util.Optional;

public enum Rank {
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    int matchCount;
    boolean bonusNeeded;
    int prize;

    Rank(int matchCount, boolean bonusNeeded, int prize) {
        this.matchCount = matchCount;
        this.bonusNeeded = bonusNeeded;
        this.prize = prize;
    }

    public static Optional<Rank> getRank(List<Integer> lotteryNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int count = getMatchCount(lotteryNumbers, winningNumbers);
        boolean bonusMatched = lotteryNumbers.contains(bonusNumber);
        for (Rank rank : Rank.values()) {
            if (isMatched(count, bonusMatched, rank)) {
                return Optional.of(rank);
            }
        }
        return Optional.empty();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNeeded() {
        return bonusNeeded;
    }

    public int getPrize() {
        return prize;
    }

    private static int getMatchCount(List<Integer> lotteryNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotteryNumbers) {
            if (winningNumbers.contains(number)) {
                count = count + Unit.ONE.getUnit();
            }
        }
        return count;
    }

    private static boolean isMatched(int matchCount, boolean bonusMatched, Rank rank) {
        if (matchCount == rank.matchCount) {
            if (rank == THIRD_PLACE && bonusMatched) {
                return false;
            }
            return true;
        }
        return false;
    }
}
