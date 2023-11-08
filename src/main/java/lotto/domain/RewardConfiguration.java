package lotto.domain;

import java.util.Arrays;

public enum RewardConfiguration {
    FIRST(new LottoResult(6, false), 2000000000),
    SECOND(new LottoResult(5, true), 30000000),
    THIRD(new LottoResult(5, false), 1500000),
    FOURTH(new LottoResult(4, false), 50000),
    FIFTH(new LottoResult(3, false), 5000);

    private final LottoResult lottoResult;
    private final int reward;

    RewardConfiguration(LottoResult lottoResult, int reward) {
        this.lottoResult = lottoResult;
        this.reward = reward;
    }

    public static int getReward(LottoResult lottoResult) {
        return Arrays.stream(RewardConfiguration.values())
                .filter(rc -> rc.lottoResult.equals(lottoResult))
                .findFirst()
                .map(rc -> rc.reward)
                .orElse(0);
    }
}
