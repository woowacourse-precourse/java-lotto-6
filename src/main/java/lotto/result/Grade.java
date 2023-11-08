package lotto.result;

import static lotto.util.Constant.DEFAULT_VALUE;
import static lotto.util.Constant.MATCHED_FIVE_NUMBER;
import static lotto.util.Constant.MATCHED_FIVE_NUMBER_AND_BONUS;
import static lotto.util.Constant.MATCHED_FOUR_NUMBER;
import static lotto.util.Constant.MATCHED_SIX_NUMBER;
import static lotto.util.Constant.MATCHED_THREE_NUMBER;
import static lotto.util.Constant.PRICE_FOR_BONUS;
import static lotto.util.Constant.PRICE_FOR_FIVE;
import static lotto.util.Constant.PRICE_FOR_FOUR;
import static lotto.util.Constant.PRICE_FOR_LESS_THAN_THREE;
import static lotto.util.Constant.PRICE_FOR_SIX;
import static lotto.util.Constant.PRICE_FOR_THREE;

public enum Grade {
    FIRST(MATCHED_SIX_NUMBER, PRICE_FOR_SIX),
    SECOND(MATCHED_FIVE_NUMBER_AND_BONUS, PRICE_FOR_BONUS),
    THIRD(MATCHED_FIVE_NUMBER, PRICE_FOR_FIVE),
    FOURTH(MATCHED_FOUR_NUMBER, PRICE_FOR_FOUR),
    FIFTH(MATCHED_THREE_NUMBER, PRICE_FOR_THREE),
    NONE(DEFAULT_VALUE, PRICE_FOR_LESS_THAN_THREE);

    private final int matchCount;
    private final long price;

    Grade(int matchCount, long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Grade of(int matchCount, boolean isBonusMatched) {
        if (matchCount == SECOND.matchCount && isBonusMatched) {
            return SECOND;
        }

        for (Grade grade : Grade.values()) {
            if (matchCount == grade.matchCount && grade != SECOND) {
                return grade;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrice() {
        return price;
    }
}
