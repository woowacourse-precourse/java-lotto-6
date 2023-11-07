package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringJoiner;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    SIXTH(2, false, 1000); //Test

    private final int matchLottoCount;
    private final boolean matchBonus;
    private final int winnerMoney;

    LottoRank(int matchLottoCount, boolean matchBonus, int winnerMoney) {
        this.matchLottoCount = matchLottoCount;
        this.matchBonus = matchBonus;
        this.winnerMoney = winnerMoney;
    }

    public static LottoRank valueOf(int matchLottoCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> matchLottoCount == lottoRank.matchLottoCount && matchBonus == lottoRank.matchBonus)
                .findAny()
                .orElse(null);
    }

    public int getMatchLottoCount() { return this.matchLottoCount; }
    public boolean getMatchBonus() { return this.matchBonus; }
    public int getWinnerMoney() { return this.winnerMoney; }
}
