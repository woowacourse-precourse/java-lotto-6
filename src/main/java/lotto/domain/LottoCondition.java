package lotto.domain;

import lotto.global.Prize;

public class LottoCondition {
    public static final Integer NUMBER_COUNT = 6;
    public static final Integer MONEY_UNIT = 1000;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    public static final Integer ROUNDING = 2;
    public static final String REGEX = ",";

    public static Prize getRank(Integer winCount, Boolean hasBonusNumber) {
        if (winCount == 6) {
            return Prize.FIRST;
        }
        if (winCount == 5) {
            if (hasBonusNumber) {
                return Prize.SECOND;
            }
            return Prize.THIRD;
        }
        if (winCount == 4) {
            return Prize.FORTH;
        }
        if (winCount == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }
}
