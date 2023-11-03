package lotto.enumerate;

import java.util.function.Function;

public enum Rank {
    FIRST_PLACE("6개 일치 (2,000,000,000원) - ", value -> (long) (value * 2000000000)),
    SECOND_PLACE("5개 일치, 보너스 일치 (30,000,000원) - ", value -> (long) (value * 30000000)),
    THIRD_PLACE("5개 일치 (1,500,000원) - ", value -> (long) (value * 1500000)),
    FOURTH_PLACE("4개 일치 (50,000원) - ", value -> (long) (value * 50000)),
    FIFTH_PLACE("3개 일치 (5,000원) - ", value -> (long) (value * 5000));
    private final String rankString;
    private final Function<Integer, Long> expression;

    Rank(String rankString, Function<Integer, Long> expression) {
        this.rankString = rankString;
        this.expression = expression;
    }

    public long calculate(int value) {
        return expression.apply(value);
    }

    public String getRankString(int value) {
        return String.format(rankString + "%d개", value);
    }
}
