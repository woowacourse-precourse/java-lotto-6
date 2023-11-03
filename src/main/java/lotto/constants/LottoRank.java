package lotto.constants;

public enum LottoRank {
    FIRST_PRIZE(6),
    SECOND_PRIZE(-1),
    THIRD_PRIZE(5),
    FOURTH_PRIZE(4),
    NO_PRIZE(0);

    private int matchedNumbers;

    LottoRank(int matchedNumbers) {
        this.matchedNumbers = matchedNumbers;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public static LottoRank getResultByMatchedNumbers(int matchedNumbers) {
        for (LottoRank result : values()) {
            if (result.matchedNumbers == matchedNumbers) {
                return result;
            }
        }
        return NO_PRIZE; // 기본적으로 NO_PRIZE 반환
    }
}
