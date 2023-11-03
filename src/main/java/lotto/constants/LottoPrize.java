package lotto.constants;

public enum LottoPrize {
    FIRST_PRIZE(6),
    SECOND_PRIZE(-1),
    THIRD_PRIZE(5),
    FOURTH_PRIZE(4),
    NO_PRIZE(0);

    private int matchedNumbers;

    LottoPrize(int matchedNumbers) {
        this.matchedNumbers = matchedNumbers;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
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
