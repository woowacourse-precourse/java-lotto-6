package lotto;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);
    //3개 일치 (5,000원) - 1개
    //4개 일치 (50,000원) - 0개
    //5개 일치 (1,500,000원) - 0개
    //5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    //6개 일치 (2,000,000,000원) - 0개

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
}
