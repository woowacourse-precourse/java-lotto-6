package lotto.model;

import static lotto.model.Bonus.BONUS_EXCLUDE;
import static lotto.model.Bonus.BONUS_INCLUDE;

import java.util.Optional;

public enum Prize {

    FIRST("6개 일치", 6, 2_000_000_000, BONUS_EXCLUDE),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000, BONUS_INCLUDE),
    THIRD("5개 일치", 5, 1_500_000, BONUS_EXCLUDE),
    FOURTH("4개 일치", 4, 50_000, BONUS_EXCLUDE),
    FIFTH("3개 일치", 3, 5_000, BONUS_EXCLUDE);

    private final String condition;
    private final int match;
    private final int money;
    private final Bonus hasBonus;

    Prize(final String condition, final int match, final int money, final Bonus hasBonus) {
        this.condition = condition;
        this.match = match;
        this.money = money;
        this.hasBonus = hasBonus;
    }

    public static Optional<Prize> findByMatchAndBonus(final int match, final boolean hasBonus) {
        for (Prize prize : values()) {
            if (!prize.hasBonus.isSame(hasBonus)) {
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
