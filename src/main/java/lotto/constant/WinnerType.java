package lotto.constant;

import java.text.NumberFormat;
import java.util.Arrays;

public enum WinnerType {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int match;
    private final boolean bonus;
    private final int prize;

    WinnerType(int match, boolean bonus, int prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static WinnerType of(int match, boolean bonus) {
        if (match == SECOND.match && bonus == SECOND.bonus) {
            return SECOND;
        }
        if (match < FIFTH.match) {
            return NOTHING;
        }
        return Arrays.stream(values())
                .filter(elem -> elem.match == match && !elem.bonus)
                .findFirst()
                .orElse(NOTHING);
    }

    public static WinnerType of(int match) {
        return of(match, false);
    }

    public String message() {
        String bonusMessage = "";
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        if (this.bonus) {
            bonusMessage = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%s원) - ", match, bonusMessage, numberFormat.format(prize));
    }

    public int getPrize() {
        return prize;
    }
}
