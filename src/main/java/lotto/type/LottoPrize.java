package lotto.type;

public enum LottoPrize {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    NONE(0, 0, " ");

    public static final int MIN_CORRECT = 3;
    private final int matchedNumber;
    private final int prize;
    private final String result;

    LottoPrize(int matchedNumber, int prize, String result) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
        this.result = result;
    }

    public static LottoPrize valueOf(int correctNum, boolean correctBonus) {
        if (correctNum < MIN_CORRECT) {
            return NONE;
        }
        if (correctBonus && correctNum == 5) {
            return SECOND;
        }
        for (LottoPrize prize : values()) {
            if (prize.matchedNumber == correctNum) {
                return prize;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getMatchedNumbers() {
        return matchedNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getResult() {
        return result;
    }
}