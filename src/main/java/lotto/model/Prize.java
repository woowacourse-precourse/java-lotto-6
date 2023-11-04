package lotto.model;

import static lotto.model.Point.FIFTH_POINT;
import static lotto.model.Point.FIRST_POINT;
import static lotto.model.Point.FOURTH_POINT;
import static lotto.model.Point.SECOND_POINT;
import static lotto.model.Point.THIRD_POINT;

public enum Prize {

    FIRST("6개 일치", FIRST_POINT.getPoint(), 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", SECOND_POINT.getPoint(), 30_000_000),
    THIRD("5개 일치", THIRD_POINT.getPoint(), 1_500_000),
    FOURTH("4개 일치", FOURTH_POINT.getPoint(), 50_000),
    FIFTH("3개 일치", FIFTH_POINT.getPoint(), 5_000);

    private final String condition;
    private final int point;
    private final int money;

    Prize(final String condition, final int point, final int money) {
        this.condition = condition;
        this.point = point;
        this.money = money;
    }

    public static Prize findByPoint(final int point) {
        for (Prize prize : values()) {
            if (prize.point == point) {
                return prize;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getCondition() {
        return condition;
    }

    public int getMoney() {
        return money;
    }
}
