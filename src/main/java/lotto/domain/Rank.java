package lotto.domain;

import java.util.function.Function;

public enum Rank {
    FIFTH(3, false, "3개 일치 (5,000원) - ", reward -> reward + 5000L),
    FOURTH(4, false, "4개 일치 (50,000원) - ", reward -> reward + 50_000L),
    THIRD(5, false, "5개 일치 (1,500,000원) - ", reward -> reward + 1_500_000L),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", reward -> reward + 30_000_000L),
    FIRST(6, false, "6개 일치 (2,000,000,000원) - ", reward -> reward + 2_000_000_000L);

    private int matchNumbers;
    private boolean matchBonus;
    private String message;
    private Function<Long, Long> calc;

    Rank(int matchNumbers, boolean matchBonus, String message, Function<Long, Long> calc) {
        this.matchNumbers = matchNumbers;
        this.matchBonus = matchBonus;
        this.message = message;
        this.calc = calc;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public String getMessage() {
        return message;
    }

    public long calculateReward(long nowCash) {
        return calc.apply(nowCash);
    }
}
