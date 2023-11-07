package lotto.domain.rank;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.domain.lotto.LottoResult;

public enum Rank {
    NONE(LottoResult.of(0, false), 0),
    FIFTH(LottoResult.of(3, false), 5_000),
    FOURTH(LottoResult.of(4, false), 50_000),
    THIRD(LottoResult.of(5, false), 1_500_000),
    SECOND(LottoResult.of(5, true), 30_000_000),
    FIRST(LottoResult.of(6, false), 2_000_000_000);

    private final LottoResult lottoResult;
    private final int reward;

    Rank(LottoResult lottoResult, int reward) {
        this.lottoResult = lottoResult;
        this.reward = reward;
    }

    public static Rank of(LottoResult lottoResult) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.lottoResult.equals(lottoResult))
                .findFirst()
                .orElse(NONE);
    }

    public static int totalReward(final EnumMap<Rank, Integer> rankResult) {
        return rankResult.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().reward * entry.getValue())
                .sum();
    }

    public LottoResult lottoResult() {
        return lottoResult;
    }

    public int matchCount() {
        return lottoResult.matchCount();
    }

    public int reward() {
        return reward;
    }
}
