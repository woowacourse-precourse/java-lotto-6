package lotto.domain.lotto;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoRank {
    NO_RANK(0, count -> 0L, ""),
    FIFTH(3, count -> count * 5000, "3개 일치 (5,000원) - %s개\n"),
    FOURTH(4, count -> count * 50000, "4개 일치 (50,000원) - %s개\n"),
    THIRD(5, count -> count * 1500000, "5개 일치 (1,500,000원) - %s개\n"),
    SECOND(5, count -> count * 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n"),
    FIRST(6, count -> count * 2000000000, "6개 일치 (2,000,000,000원) - %d개\n");

    private static final int CHECK_MATCH_COUNT_VALUE = 5;
    private final int matchCount;
    private final Function<Long, Long> expression;
    private final String message;

    LottoRank(int matchCount, Function<Long, Long> expression, String message) {
        this.matchCount = matchCount;
        this.message = message;
        this.expression = expression;
    }

    public String printRankMessage() {
        return message;
    }

    public long calculatePrize(long count) {
        return expression.apply(count);
    }

    public static LottoRank getRank (int count, boolean isBonus) {
        if (count == CHECK_MATCH_COUNT_VALUE) {
            return getRankWithBonus(isBonus);
        }

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> isRank(count, lottoRank))
                .findAny()
                .orElse(NO_RANK);
    }

    private static LottoRank getRankWithBonus(boolean isBonus) {
        if (isBonus){
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    private static boolean isRank(int count, LottoRank lottoRank) {
        return lottoRank.matchCount == count;
    }

}
