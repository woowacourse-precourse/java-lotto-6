package lotto.view.constants;

import lotto.domain.prize.constants.PrizeGrade;

import static lotto.domain.prize.constants.PrizeGrade.*;
import static lotto.view.constants.PrizeResultFormat.RESPONSE_MATCHING;
import static lotto.view.constants.PrizeResultFormat.RESPONSE_MATCHING_WITH_BONUS;

public enum PrintablePrizeType {
    MATCHING_SIX(HIT_SIX, RESPONSE_MATCHING),
    MATCHING_FIVE_AND_BONUS(HIT_FIVE_AND_BONUS, RESPONSE_MATCHING_WITH_BONUS),
    MATCHING_FIVE(HIT_FIVE, RESPONSE_MATCHING),
    MATCHING_FOUR(HIT_FOUR, RESPONSE_MATCHING),
    MATCHING_THREE(HIT_THREE, RESPONSE_MATCHING);

    private final PrizeGrade grade;
    private final PrizeResultFormat format;

    PrintablePrizeType(PrizeGrade grade, PrizeResultFormat format) {
        this.grade = grade;
        this.format = format;
    }

    public PrizeGrade getGrade() {
        return grade;
    }

    public String getFormat() {
        return format.getFormat();
    }
}
