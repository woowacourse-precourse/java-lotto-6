package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoCriteria {
    FIRST_PLACE(6, 2000000000, false),
    SECOND_PLACE(5, 30000000, true),
    THIRD_PLACE(5, 1500000, false),
    FOURTH_PLACE(4, 50000, false),
    FIFTH_PLACE(3, 5000, false);

    private final int matchNumber;
    private final long amount;
    private final boolean hasBonus;

    LottoCriteria(final int matchNumber, final long amount, final boolean hasBonus) {
        this.matchNumber = matchNumber;
        this.amount = amount;
        this.hasBonus = hasBonus;
    }

    public final int getMatchNumber() {
        return matchNumber;
    }

    public final long getAmount() {
        return amount;
    }

    public final boolean hasBonus() {
        return hasBonus;
    }

    public static final List<LottoCriteria> getAllValues() {
        return Arrays.asList(LottoCriteria.values());
    }
}
