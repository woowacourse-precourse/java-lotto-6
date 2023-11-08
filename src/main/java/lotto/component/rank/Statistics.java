package lotto.component.rank;

import java.util.Arrays;

public enum Statistics {
    NONE(6, ""), THREE(5, "3개 일치 (5,000원)"), FOUR(4, "4개 일치 (50,000원)"), FIVE(3, "5개 일치 (1,500,000원)"), BONUS(2,
            "5개 일치, 보너스 볼 일치 (30,000,000원)"), SIX(1, "6개 일치 (2,000,000,000원)");

    private final Integer rank;

    private final String statistics;

    Statistics(Integer rank, String statistics) {
        this.rank = rank;
        this.statistics = statistics;
    }

    public static String getStatistics(Integer rank) {
        return Arrays.stream(Statistics.values()).filter(r -> r.rank.equals(rank)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("설명을 찾을 수 없습니다.")).statistics;
    }

}
