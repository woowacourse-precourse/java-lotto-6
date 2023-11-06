package lotto.domain.lotto;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

//View의 계산을 도와주는 로직인데 domain에서 알고 있는거 분리해보기

/**
 * DTO로 서비스 로직 분리하기
 */
public enum LottoRank {
    NO_RANK(0, count -> 0L,
            count -> System.out.printf("")),
    FIFTH(3, count -> count * 5000,
            count -> System.out.printf("3개 일치 (5,000원) - %s개\n",count)),
    FOURTH(4, count -> count * 50000,
            count -> System.out.printf("4개 일치 (50,000원) - %s개\n",count)),
    THIRD(5, count -> count * 1500000,
            count -> System.out.printf("5개 일치 (1,500,000원) - %s개\n",count)),
    SECOND(5, count -> count * 30000000,
            count -> System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n",count)),
    FIRST(6, count -> count * 2000000000,
            count -> System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", count));

    private static final int CHECK_MATCH_COUNT_VALUE = 5;
    private final int matchCount;
    private final Function<Long, Long> expression;
    private final Consumer<Long> rankMessage;

    LottoRank(int matchCount, Function<Long, Long> expression, Consumer<Long> rankMessage) {
        this.matchCount = matchCount;
        this.rankMessage = rankMessage;
        this.expression = expression;
    }

    public void printRankMessage(long count) {
        rankMessage.accept(count);
    }

    public long calculate(long count) {
        return expression.apply(count);
    }

    public static LottoRank getRank (int count, boolean isBonus) {
        if (count == CHECK_MATCH_COUNT_VALUE) {
            return getRankWithBonus(isBonus);
        }

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == count)
                .findAny()
                .orElse(NO_RANK);
    }

    private static LottoRank getRankWithBonus(boolean isBonus) {
        if (isBonus){
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }


}
