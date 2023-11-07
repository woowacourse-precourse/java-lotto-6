package lotto.domain;

import java.util.Arrays;

public enum LottoGrade {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);


    private final int matchCount;
    private final int prize;

    LottoGrade(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoGrade getLottoGrade(int matchNumberCount, boolean isMatchBonus) {
        if (matchNumberCount == 5) {
            return bonusNumberMatch(isMatchBonus);
        }

        return Arrays.stream(values())
                .filter(grade -> grade.matchCount == matchNumberCount)
                .findAny()
                .orElse(NONE);
    }

    private static LottoGrade bonusNumberMatch(boolean isMatchBonus) {
        if (isMatchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
