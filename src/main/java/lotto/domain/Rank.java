package lotto.domain;

public enum Rank {
    FIFTH_PRIZE(3, false, 5_000L, "3개 일치 (5,000원) - "),
    FOURTH_PRIZE(4, false, 50_000L, "4개 일치 (50,000원) - "),
    THIRD_PRIZE(5, false, 1_500_000L, "5개 일치 (1,500,000원) - "),
    SECOND_PRIZE(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PRIZE(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원) - "),
    NONE(0, false, 0L, ""),
    ;

    private final Integer correctCount;
    private final boolean bonusNumber;
    private final Long prize;
    private String message;

    Rank(Integer correctCount, boolean bonusNumber, Long prize, String message) {
        this.correctCount = correctCount;
        this.bonusNumber = bonusNumber;
        this.prize = prize;
        this.message = message;
    }

    public static Rank matching(int correctCount,boolean bonusNumber) {
        if (correctCount < FIFTH_PRIZE.correctCount) {
            return NONE;
        }
        for (Rank rank : values()) {
            if (rank.correctCount==correctCount) {
                if (correctCount==SECOND_PRIZE.correctCount && bonusNumber) return SECOND_PRIZE;
                return rank;
            }
        }
        return NONE;
    }

    public Long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
