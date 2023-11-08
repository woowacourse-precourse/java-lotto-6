package lotto;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NONE(0, 0);

    private final int correctCount;
    private final int winning;

    Prize(int correctCount, int winning) {
        this.correctCount = correctCount;
        this.winning = winning;
    }

    public static Prize getByCountAndBonus(long correctCount, boolean containsBonus){
        if (containsBonus){
            correctCount++;
        }
        if (correctCount < 3) {
            return NONE;
        }
        if (correctCount == 5 && !containsBonus){
            return THIRD;
        }
        if (correctCount == 5){
            return SECOND;
        }
        return getPrizeByCount(correctCount);
    }

    public static Prize getPrizeByCount(long correctCount) {
        for (Prize prize : values()) {
            if (prize.correctCount == correctCount) {
                return prize;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getWinning() {
        return winning;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
