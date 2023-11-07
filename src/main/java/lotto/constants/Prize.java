package lotto.constants;

import java.util.function.BiFunction;

public enum Prize {
    NONE(0, false,0, (matchCount, matchBonus) -> matchCount < 3),
    FIFTH(3, false,5_000, (matchCount, matchBonus) -> matchCount == 3),
    FOURTH(4, false,50_000, (matchCount, matchBonus) -> matchCount == 4),
    THIRD(5, false,1_500_000, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    SECOND(5, true, 30_000_000, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    FIRST(6, false, 2_000_000_000, (matchCount, matchBonus) -> matchCount == 6);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final BiFunction<Integer, Boolean, Boolean> check;

    Prize(int matchCount, boolean matchBonus, int prize, BiFunction<Integer,Boolean,Boolean> check) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.check = check;
    }

    public boolean match(int count, boolean bonus) {
        return check.apply(count, bonus);
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d개 일치", matchCount));
        if (matchBonus) {
            output.append(", 보너스 볼 일치");
        }
        output.append(String.format(" (%,d원)", prize));
        return output.toString();
    }
}
