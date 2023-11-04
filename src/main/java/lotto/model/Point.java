package lotto.model;

import static lotto.model.LottoConstant.BONUS_MATCH_POINT;
import static lotto.model.LottoConstant.FIFTH_PRIZE_MATCH;
import static lotto.model.LottoConstant.FOURTH_PRIZE_MATCH;
import static lotto.model.LottoConstant.GOAL_MATCH_POINT;
import static lotto.model.LottoConstant.LOTTO_NUMBERS_SIZE;
import static lotto.model.LottoConstant.SECOND_PRIZE_MATCH;
import static lotto.model.LottoConstant.THIRD_PRIZE_MATCH;

public enum Point {

    FIRST_POINT(GOAL_MATCH_POINT.getValue() * LOTTO_NUMBERS_SIZE.getValue()),
    SECOND_POINT(GOAL_MATCH_POINT.getValue() * SECOND_PRIZE_MATCH.getValue() + BONUS_MATCH_POINT.getValue()),
    THIRD_POINT(GOAL_MATCH_POINT.getValue() * THIRD_PRIZE_MATCH.getValue()),
    FOURTH_POINT(GOAL_MATCH_POINT.getValue() * FOURTH_PRIZE_MATCH.getValue()),
    FIFTH_POINT(GOAL_MATCH_POINT.getValue() * FIFTH_PRIZE_MATCH.getValue());

    Point(final int point) {
        this.point = point;
    }

    private final int point;

    public int getPoint() {
        return point;
    }
}
