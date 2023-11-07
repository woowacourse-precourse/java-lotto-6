package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public static int getTotalPrize(Map<LottoGrade, Integer> result) {
        List<Integer> lottoGradeCount = new ArrayList<>(result.values());
        int FirstPrize = LottoGrade.FIRST.prize * lottoGradeCount.get(0);
        int SecondPrize = LottoGrade.SECOND.prize * lottoGradeCount.get(1);
        int ThirdPrize = LottoGrade.THIRD.prize * lottoGradeCount.get(2);
        int FourthPrize = LottoGrade.FOURTH.prize * lottoGradeCount.get(3);
        int FifthPrize = LottoGrade.FIFTH.prize * lottoGradeCount.get(4);

        return FirstPrize + SecondPrize + ThirdPrize + FourthPrize + FifthPrize;
    }
}
