package lotto.constant;

public enum LottoPrize {
    NO_MATCH(0, false, 0),
    MATCH_3(3, false, 5000),
    MATCH_4(4, false, 50000),
    MATCH_5(5, false, 1500000),
    MATCH_5_BONUS(5, true, 30000000),
    MATCH_6(6, false, 2000000000);

    private final Integer correctCount;
    private final Boolean isBonusCorrect;
    private final Integer prize;

    LottoPrize(Integer correctCount, Boolean isBonusCorrect, Integer prize) {
        this.correctCount = correctCount;
        this.isBonusCorrect = isBonusCorrect;
        this.prize = prize;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public Boolean getIsBonusCorrect() {
        return isBonusCorrect;
    }

    public Integer getPrize() {
        return prize;
    }

    public Boolean canGetPrize(Integer correctCount, Boolean isBonusCorrect) {
        if (this.isBonusCorrect) {
            return isCorrectCountEqual(correctCount) && isBonusCorrect;
        }
        return isCorrectCountEqual(correctCount);
    }

    private Boolean isCorrectCountEqual(Integer correctCount) {
        return this.correctCount == correctCount;
    }
}

