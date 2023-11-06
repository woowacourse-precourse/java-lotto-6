package lotto.model;

import java.util.Arrays;

public enum LottoResult {

    MATCH_3(3, 5000, false),
    MATCH_4(4, 50000, false),
    MATCH_5(5, 1500000, false),
    MATCH_5_BONUS(5, 30000000, true),
    MATCH_6(6, 2000000000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean matchBonus;

    LottoResult(int matchCount, int prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static LottoResult findResult(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return MATCH_5_BONUS;
        }

        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }
}
