package lotto.domain.lotto;

import java.util.Arrays;
import java.util.function.Consumer;

public enum LottoRank {
    NO_RANK(0, 0,
            count -> System.out.printf("")),
    FIFTH(3, 5000,
            count -> System.out.printf("3개 일치 (5,000원) - %s개\n",count)),
    FOURTH(4, 50000,
            count -> System.out.printf("4개 일치 (50,000원) - %s개\n",count)),
    THIRD(5, 1500000,
            count -> System.out.printf("5개 일치 (1,500,000원) - %s개\n",count)),
    SECOND(5, 30000000,
            count -> System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n",count)),
    FIRST(6, 2000000000,
            count -> System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", count));

    private static final int CHECK_MATCH_COUNT_VALUE = 5;
    private final int matchCount;
    private final Consumer<Long> rankMessage;
    private final int winningAmount;

    LottoRank(int matchCount, int winningAmount, Consumer<Long> rankMessage) {
        this.matchCount = matchCount;
        this.rankMessage = rankMessage;
        this.winningAmount = winningAmount;
    }

    public void accept(long count) {
        rankMessage.accept(count);
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
