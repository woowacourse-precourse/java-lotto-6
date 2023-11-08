package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public enum WinningStatistics {
    FIRST(6, 2_000_000_000, false, "\n6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, true, "\n5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, false, "\n5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, false, "\n4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, false, "3개 일치 (5,000원) - "),
    NOTHING(0, 0, false, "");

    public static final int BONUS_NUMBER_CONDITION = 5;

    private int matchCount;
    private final int reward;
    private final boolean isContainBonus;
    private final String message;

    WinningStatistics(final int matchCount, final int reward, final boolean isContainBonus, final String message) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.isContainBonus = isContainBonus;
        this.message = message;
    }

    public List<Integer> getMatchCount() {
        List<Integer> counts = new ArrayList<>();
        counts.add(FIRST.matchCount);
        counts.add(SECOND.matchCount);
        counts.add(THIRD.matchCount);
        counts.add(FOURTH.matchCount);
        counts.add(FIFTH.matchCount);

        return counts;
    }

    public boolean isContainBonus() {
        return isContainBonus;
    }

    public String getMessage() {
        return message;
    }
}