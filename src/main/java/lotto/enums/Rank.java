package lotto.enums;

import java.util.Arrays;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

public enum Rank {
    MISS(0, "", 0),
    FIFTH_PLACE(3, "3개 일치 (5,000원) - %d개\n", 5_000),
    FOURTH_PLACE(4, "4개 일치 (50,000원) - %d개\n", 50_000),
    THIRD_PLACE(5, "5개 일치 (1,500,000원) - %d개\n", 1_500_000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30_000_000),
    FIRST_PLACE(6, "6개 일치 (2,000,000,000원) - %d개\n", 2_000_000_000);

    private final int requiredMatches;
    private final String matchInfo;
    private final int prize;

    Rank(int requiredMatches, String matchInfo, int prize) {
        this.requiredMatches = requiredMatches;
        this.matchInfo = matchInfo;
        this.prize = prize;
    }

    public String getMatchInfo() {
        return matchInfo;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank findRank(WinningNumber winningNumber, BonusNumber bonusNumber, Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningNumber);
        boolean matchBonus = lotto.isMatchBonus(bonusNumber);
        if (isSecondPlace(matchCount, matchBonus)) {
            return SECOND_PLACE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.requiredMatches == matchCount)
                .findAny()
                .orElse(MISS);
    }

    private static boolean isSecondPlace(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return true;
        }
        return false;
    }
}

