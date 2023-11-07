package lotto.Domain;

import java.util.Arrays;
import java.util.Optional;


public enum LottoRank {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000);

    private final int match;
    private final int bonus;
    private final int reward;

    LottoRank(final int match, final int bonus, final int reward) {
        this.match = match;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static Optional<LottoRank> computeLottoRank(int match, int bonus) {
        return Arrays.stream(values()).filter(lottoRank ->
                lottoRank.match == match & lottoRank.bonus <= bonus
        ).findFirst();
    }

    public int getMatch() {
        return match;
    }

    public int getBonus() {
        return bonus;
    }

    public int getReward() {
        return reward;
    }
}
