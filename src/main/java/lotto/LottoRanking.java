package lotto;

public enum LottoRanking {
    FIRST_PRIZE,
    SECOND_PRIZE,
    THIRD_PRIZE,
    FOURTH_PRIZE,
    FIFTH_PRIZE,
    DID_NOT_WIN;

    public static LottoRanking getLottoRanking(long matchCount, boolean hasBonusNumber) {
        if (matchCount < 3) {
            return DID_NOT_WIN;
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE;
        }
        if (matchCount == 4) {
            return FOURTH_PRIZE;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            return THIRD_PRIZE;
        }
        if (matchCount == 5) {
            return SECOND_PRIZE;
        }
        return FIRST_PRIZE;
    }
}
