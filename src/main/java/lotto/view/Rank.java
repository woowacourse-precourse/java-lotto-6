package lotto.view;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NOTHING(0, 0, false, "0개 일치 - "),
    FIFTH(5_000, 3, false,"3개 일치 (5,000원) - "),
    FOURTH(50_000, 4, false,"4개 일치 (50,000원) - "),

    THIRD(1_500_000, 5, false,"5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, false,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, 6, false,"6개 일치 (2,000,000,000원) - ");

    private final int reward;
    private final int mathCount;
    private final boolean containBonus;
    private final String message;

    Rank(final int reward, final int mathCount, boolean containBonus, String message) {
        this.reward = reward;
        this.mathCount = mathCount;
        this.containBonus = containBonus;
        this.message = message;
    }

    public static Rank calculate(int correctNumCount, boolean containBonus) {
        return Arrays.stream(values())
                .filter(rank -> correctNumCount == rank.mathCount)
                .filter(rank -> containBonus==rank.containBonus)
                .findAny()
                .orElse(NOTHING);
    }

    public int getMoney() {
        return reward;
    }

}
