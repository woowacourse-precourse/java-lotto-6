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

    private static final int SECOND_THIRD_MATCH_NUMBER_COUNT = 5;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;
    private static final int FOURTH_INDEX = 3;
    private static final int FIFTH_INDEX = 4;

    private final int matchCount;
    private final int prize;

    LottoGrade(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoGrade getLottoGrade(int matchNumberCount, boolean isMatchBonus) {
        if (matchNumberCount == SECOND_THIRD_MATCH_NUMBER_COUNT) {
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
        int FirstPrize = LottoGrade.FIRST.prize * lottoGradeCount.get(FIRST_INDEX);
        int SecondPrize = LottoGrade.SECOND.prize * lottoGradeCount.get(SECOND_INDEX);
        int ThirdPrize = LottoGrade.THIRD.prize * lottoGradeCount.get(THIRD_INDEX);
        int FourthPrize = LottoGrade.FOURTH.prize * lottoGradeCount.get(FOURTH_INDEX);
        int FifthPrize = LottoGrade.FIFTH.prize * lottoGradeCount.get(FIFTH_INDEX);

        return FirstPrize + SecondPrize + ThirdPrize + FourthPrize + FifthPrize;
    }
}
