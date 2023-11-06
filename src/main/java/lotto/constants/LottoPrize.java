package lotto.constants;

public enum LottoPrize {
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(-1, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000),
    NO_PRIZE(0, 0);

    private int matchedNumbers;
    private int winningPrize;

    LottoPrize(int matchedNumbers, int winningPrize) {
        this.matchedNumbers = matchedNumbers;
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static LottoPrize getResultByMatchedNumbers(int matchedNumbers) {
        for (LottoPrize result : values()) {
            if (result.matchedNumbers == matchedNumbers) {
                return result;
            }
        }
        return NO_PRIZE; // 기본적으로 NO_PRIZE 반환
    }
}
