package lotto.enums;

import java.text.DecimalFormat;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    FAIL(0, 0, false);

    private final int countMatch;
    private final int prize;
    private final boolean bonus;

    Rank(int countMatch, int prize, boolean bonus) {
        this.countMatch = countMatch;
        this.prize = prize;
        this.bonus = bonus;
    }

    public boolean isMatchBonus(int count, boolean bonus) {
        if (count == 5) {
            return this.bonus == bonus;
        }

        return this.countMatch == count;
    }

    public String getFormattedPrize() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(this.prize);
    }

    public String getMatchMessage() {
        if (this == SECOND) {
            return this.countMatch + "개 일치, 보너스 볼 일치";
        }
        return this.countMatch + "개 일치";
    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getPrize() {
        return prize;
    }
}
