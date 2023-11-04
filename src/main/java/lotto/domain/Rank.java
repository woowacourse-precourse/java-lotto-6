package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    ONE(1, 6, 2000000000, List.of(true, false)),
    TWO(2, 5, 30000000, List.of(true)),
    THREE(3, 5, 1500000, List.of(false)),
    FOUR(4, 4, 50000, List.of(true, false)),
    FIVE(5, 3, 5000, List.of(true, false)),
    NONE(-1, 0, 0, List.of(true, false));

    private static final String INVALID_COUNT_EXCEPTION = "존재하지 않는 당첨 개수입니다.";

    private final int ranking;
    private final int matchCount;
    private final int reward;
    private final List<Boolean> bonusMatchCases;

    Rank(int ranking, int matchCount, int reward, List<Boolean> bonusMatchCases) {
        this.ranking = ranking;
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonusMatchCases = bonusMatchCases;
    }

    public static Rank find(int count, boolean hasBonusNumber) {
        if (NONE.matchCount <= count && count < FIVE.matchCount) {
            return NONE;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == count && rank.bonusMatchCases.contains(hasBonusNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT_EXCEPTION));
    }

    @Override
    public String toString() {
        if (this.equals(TWO)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)", matchCount, reward);
        }
        return String.format("%d개 일치 (%d원)", matchCount, reward);
    }

    public int getRanking() {
        return ranking;
    }
}
