package lotto;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NO_LUCK(0, 2),
    ;


    private final int prize;
    private final int correctNumberCount;

    LottoRanking(int prize, int correctNumberCount) {
        this.prize = prize;
        this.correctNumberCount = correctNumberCount;
    }

    public static LottoRanking findByCondition(int correctNumberCount, boolean isCorrectBonusNumber) {
        if (correctNumberCount == 5) {
            if (isCorrectBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.correctNumberCount == correctNumberCount)
                .findFirst()
                .orElse(NO_LUCK);
    }
}
