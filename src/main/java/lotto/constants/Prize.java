package lotto.constants;

import java.util.Optional;

public enum Prize {

    FIRST("6개 일치", 6, 2_000_000_000, false),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000, true),
    THIRD("5개 일치", 5, 1_500_000, false),
    FOURTH("4개 일치", 4, 50_000, false),
    FIFTH("3개 일치", 3, 5_000, false);

    private final String condition;
    private final int match;
    private final int money;
    private final boolean hasBonus;

    Prize(final String condition, final int match, final int money, final boolean hasBonus) {
        this.condition = condition;
        this.match = match;
        this.money = money;
        this.hasBonus = hasBonus;
    }

    public static Optional<Prize> findByMatchExceptBonus(final int match) {
        for (Prize prize : values()) {
            if (prize.hasBonus) {
                continue;
            }
            if (prize.match == match) {
                return Optional.of(prize);
            }
        }
        return Optional.empty();
    }

    public static Optional<Prize> findByMatchWithBonus(final int match) {
        for (Prize prize : values()) {
            if (!prize.hasBonus) {
                continue;
            }
            if (prize.match == match) {
                return Optional.of(prize);
            }
        }
        return Optional.empty();
    }

    public String getCondition() {
        return condition;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }
}
