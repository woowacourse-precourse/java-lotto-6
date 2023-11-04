package lotto.model;

import static lotto.model.LottoConstant.FIFTH_PRIZE_MATCH;
import static lotto.model.LottoConstant.FOURTH_PRIZE_MATCH;
import static lotto.model.LottoConstant.LOTTO_NUMBERS_SIZE;
import static lotto.model.LottoConstant.SECOND_PRIZE_MATCH;
import static lotto.model.LottoConstant.THIRD_PRIZE_MATCH;

public enum Point {

    BONUS_MATCH_POINT(50),
    GOAL_MATCH_POINT(100),
    FIRST_POINT(GOAL_MATCH_POINT.getPoint() * LOTTO_NUMBERS_SIZE.getValue()),
    SECOND_POINT(GOAL_MATCH_POINT.getPoint() * SECOND_PRIZE_MATCH.getValue() + BONUS_MATCH_POINT.getPoint()),
    THIRD_POINT(GOAL_MATCH_POINT.getPoint() * THIRD_PRIZE_MATCH.getValue()),
    FOURTH_POINT(GOAL_MATCH_POINT.getPoint() * FOURTH_PRIZE_MATCH.getValue()),
    FIFTH_POINT(GOAL_MATCH_POINT.getPoint() * FIFTH_PRIZE_MATCH.getValue());

    Point(final int point) {
        this.point = point;
    }

    private final int point;

    public int getPoint() {
        return point;
    }
}
