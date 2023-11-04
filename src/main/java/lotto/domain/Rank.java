package lotto.domain;


import java.util.Arrays;
import java.util.List;

public enum Rank {
    CORRECT_THREE(3, 5000L),
    CORRECT_FOUR(4, 50000L),
    CORRECT_FIVE(5, 1500000L),
    CORRECT_FIVE_BONUS(5, 30000000L),
    CORRECT_SIX(6, 2000000000L);

    private final int correctCount;
    private final Long winningAmount;

    Rank(int correctCount, Long winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public static Rank of(int correctCount, boolean correctBonus) {
        List<Rank> ranks = findRanksByCorrectCount(correctCount);

        if (ranks.size() == 2) {
            return selectRankFromBonus(correctBonus);
        }

        return ranks.get(0);
    }

    private static List<Rank> findRanksByCorrectCount(int correctCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.getCorrectCount() == correctCount)
                .toList();
    }

    private static Rank selectRankFromBonus(boolean correctBonus) {
        if (correctBonus) {
            return CORRECT_FIVE_BONUS;
        }
        return CORRECT_FIVE;
    }


    public int getCorrectCount() {
        return correctCount;
    }

    public Long getWinningAmount() {
        return winningAmount;
    }
}
