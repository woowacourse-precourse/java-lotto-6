package lotto.domain;

import java.util.function.Function;

public enum Reward {
    FIRST_PLACE("6개 일치 (2,000,000,000원)", count -> (long) count * 2_000_000_000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)", count -> (long) count * 30_000_000),
    THIRD_PLACE("5개 일치 (1,500,000원)", count -> (long) count * 1_500_000),
    FOURTH_PLACE("4개 일치 (50,000원)", count -> (long) count * 50_000),
    FIFTH_PLACE("3개 일치 (5,000원)", count -> (long) count * 5_000);

    private final String value;
    private final Function<Integer, Long> expression;

    Reward(String value, Function<Integer, Long> expression) {
        this.value = value;
        this.expression = expression;
    }

    public String getValue() {
        return value;
    }

    public long calculate(int count) {
        return expression.apply(count);
    }
}
