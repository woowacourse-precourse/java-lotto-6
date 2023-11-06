package lotto.util;

import java.util.Arrays;

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

    public static int getGrade(long matchedNumber, boolean bonusResult) {
        if(matchedNumber < 3) return 0;
        if(matchedNumber == SECOND_GRADE.grade && bonusResult) return SECOND_GRADE.grade;
        return Arrays.stream(values())
                .filter(value -> value.matchedNumber == matchedNumber)
                .findFirst().get().grade;
    }
}