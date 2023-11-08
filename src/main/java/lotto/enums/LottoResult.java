package lotto.enums;

/**
 * 로또 결과 enum 클래스
 */
public enum LottoResult {

    NO_MATCH(0, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private int matchCount;
    private int winningMoney;

    LottoResult(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoResult parse(int matchCount, boolean isBonusMatch) {
        for (LottoResult result : LottoResult.values()) {
            if (result.matchCount == matchCount) {
                if (result == FIVE_MATCH && isBonusMatch) {
                    return FIVE_MATCH_WITH_BONUS;
                }
                return result;
            }
        }
        return NO_MATCH;
    }

    public String toString() {
        if (this == FIVE_MATCH_WITH_BONUS) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", matchCount, winningMoney);
        }
        return String.format("%d개 일치 (%,d원)", matchCount, winningMoney);
    }

}
