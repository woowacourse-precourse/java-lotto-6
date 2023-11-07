package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Prize {
    FIRST(6, false, "6개 일치", 2_000_000_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD(5, false, "5개 일치", 1_500_000),
    FOURTH(4, false, "4개 일치", 50_000),
    FIFTH(3, false, "3개 일치", 5_000),
    MISS(0, false, "꽝", 0);

    int countOfMatch;
    boolean matchBonus;
    String description;
    int money;
    private final DecimalFormat formatter = new DecimalFormat("#,###");

    Prize(int countOfMatch, boolean matchBonus, String description, int money) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.description = description;
        this.money = money;
    }

    public static Prize valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.countOfMatch == countOfMatch && prize.matchBonus == matchBonus)
                .findAny()
                .orElse(MISS);
    }

    @Override
    public String toString() {
        return description + " (" + formatter.format(money) + "원)";
    }
}
