package lotto.util;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {
    FIRST_GRADE(6, false, 1),
    SECOND_GRADE(5, true, 2),
    THIRD_GRADE(5, false, 3),
    FOURTH__GRADE(4, false, 4),
    FIFTH_GRADE(3, false, 5)
    ;

    private final int matchedNumber;
    private final boolean bonusResult;
    private final int grade;

    LottoResult(int matchedNumber, boolean bonusResult, int grade) {
        this.matchedNumber = matchedNumber;
        this.bonusResult = bonusResult;
        this.grade = grade;
    }

    public static int getGrade(int matchedNumber, boolean bonusResult) {
        List<LottoResult> lottoResults = Arrays.stream(values())
                .filter(value -> value.matchedNumber == matchedNumber)
                .toList();

        if(matchedNumber != 5) return lottoResults.get(0).grade;
        if(bonusResult) return 2;
        return 3;
    }
}