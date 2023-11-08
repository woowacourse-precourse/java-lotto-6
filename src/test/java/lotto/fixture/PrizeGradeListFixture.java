package lotto.fixture;

import lotto.domain.prize.constants.PrizeGrade;

import java.util.List;

import static lotto.domain.prize.constants.PrizeGrade.*;

public enum PrizeGradeListFixture {
    VALID(List.of(HIT_ONE, HIT_TWO, HIT_THREE, HIT_FOUR, HIT_FIVE, HIT_FIVE_AND_BONUS, HIT_SIX));


    PrizeGradeListFixture(List<PrizeGrade> prizeGrades) {
        this.prizeGrades = prizeGrades;
    }

    private final List<PrizeGrade> prizeGrades;

    public List<PrizeGrade> getPrizeGrades() {
        return prizeGrades;
    }
}
