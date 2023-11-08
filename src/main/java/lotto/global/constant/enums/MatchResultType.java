package lotto.global.constant.enums;

import java.util.function.Function;

public enum MatchResultType {
    BOOM("", value -> value * 0L), // 임의의 꽝 데이터
    MATCH_THREE("3개 일치 (5,000원) - %d개\n", value -> value * 5_000),
    MATCH_FOUR("4개 일치 (50,000원) - %d개\n", value -> value * 50_000),
    MATCH_FIVE("5개 일치 (1,500,000원) - %d개\n", value -> value * 1_500_000),
    MATCH_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", value -> value * 30_000_000),
    MATCH_SIX("6개 일치 (2,000,000,000원) - %d개", value -> value * 2_000_000_000);

    private final String format;

    private final Function<Long, Long> expression;

    MatchResultType(String format, Function<Long, Long> expression) {
        this.format = format;
        this.expression = expression;
    }

    public String getFormat() {
        return this.format;
    }

    public long calculateReward(long count) {
        return expression.apply(count);
    }


}
