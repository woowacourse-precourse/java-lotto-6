package lotto.config;

import java.util.Arrays;

public enum RankType {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private final int rank;
    private final int correctCount;
    private final int price;

    RankType(int rank, int correctCount, int price) {
        this.rank = rank;
        this.correctCount = correctCount;
        this.price = price;
    }

    public static RankType findByCorrectCount(int correctCount, boolean hasBonus) {
        RankType rankType = Arrays.stream(values())
                .filter(v -> v.getCorrectCount() == correctCount)
                .findAny()
                .orElse(null);

        if (rankType != null && rankType.getCorrectCount() == RankType.SECOND.correctCount) {
            rankType = checkHasBonus(hasBonus);
        }

        return rankType;
    }

    private static RankType checkHasBonus(boolean hasBonus) {
        if (hasBonus) {
            return RankType.SECOND;
        }
        return RankType.THIRD;
    }

    public int getRank() {
        return rank;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public static RankType findByRank(int rank) {
        return Arrays.stream(values())
                .filter(v -> v.getRank() == rank)
                .findAny()
                .orElse(null);
    }

    public int getPrice() {
        return price;
    }
}
