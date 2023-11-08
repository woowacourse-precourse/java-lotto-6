package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    LOSE(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");
    private final int matchCount;
    private final int winningMoney;
    private final String Message;

    Rank(int matchCount, int winningMoney, String message) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.Message = message;
    }

    public static Rank getRank(int matchCount, boolean containBonusNumber) {
        if (matchCount == SECOND.matchCount && containBonusNumber) {
            return SECOND;
        }

        if (matchCount < FIFTH.matchCount) {
            return LOSE;
        } else {
            return Arrays.stream(values())
                    .filter(rank -> rank.matchCount == matchCount).findAny()
                    .orElseThrow(NoSuchElementException::new);
        }
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return Message;
    }
}
