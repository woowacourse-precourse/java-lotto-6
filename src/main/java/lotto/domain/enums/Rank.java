package lotto.domain.enums;

import static lotto.domain.enums.LottoConstants.CHECK_BONUS_COUNT;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public enum Rank {
    FIFTH(3, 5_000, false, "%d개 일치 (%s원) - %d개"),
    FOURTH(4, 50_000, false, "%d개 일치 (%s원) - %d개"),
    THIRD(5, 1_500_000, false, "%d개 일치 (%s원) - %d개"),
    SECOND(5, 30_000_000, true, "%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    FIRST(6, 2_000_000_000, false, "%d개 일치 (%s원) - %d개"),
    MISS(0, 0, false, "낙첨");

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonus;
    private final String message;

    Rank(int matchCount, int prizeMoney, boolean bonus, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank getLottoRank(Lotto lotto, LottoResult lottoResult) {
        int matchCount = getMatchCount(lotto, lottoResult.getWinningNumber());

        boolean matchedBonus = false;
        if (matchCount == CHECK_BONUS_COUNT) {
            matchedBonus = lotto.isContainsNumber(lottoResult.getBonusNumber());
        }

        return caculateRank(matchCount, matchedBonus);
    }

    private static int getMatchCount(Lotto lotto, List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(lotto::isContainsNumber)
                .count();
    }

    private static Rank caculateRank(int matchCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(Rank -> Rank.matchCount == matchCount && Rank.bonus == bonus)
                .findAny()
                .orElse(MISS);
    }
}
//"5개 일치 (1,500,000원) - 0개