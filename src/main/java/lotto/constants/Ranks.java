package lotto.constants;

import java.util.Arrays;

public enum Ranks {
    FIFTH(
            5000,
            3,
            false
    ),
    FOURTH(
            500000,
            4,
            false
    ),
    THIRD(
            1500000,
            5,
            false
    ),
    SECOND(
            30000000,
            5,
            true
    ),
    FIRST(
            2000000000,
            6,
            false
    );

    private final int money;
    private final int matchLottoCount;
    private final Boolean needBonus;

    Ranks(
            final int money,
            final int matchLottoCount,
            final Boolean needBonus
    ) {
        this.money = money;
        this.matchLottoCount = matchLottoCount;
        this.needBonus = needBonus;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchLottoCount() {
        return matchLottoCount;
    }

    public static Ranks findBy(
            int matchLottoCount,
            Boolean needBonus
    ) {
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchLottoCount() == matchLottoCount && rank.needBonus == needBonus)
                .findFirst()
                .orElse(null);

    }
}
