package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {

    ONE(1, 6, 2000000000, List.of(true, false)),
    TWO(2, 5, 30000000, List.of(true)),
    THREE(3, 5, 1500000, List.of(false)),
    FOUR(4, 4, 50000, List.of(true, false)),
    FIVE(5, 3, 5000, List.of(true, false)),
    NONE(-1, 0, 0, List.of(true, false));

    private static final String INVALID_COUNT_EXCEPTION = "존재하지 않는 당첨 개수입니다.";

    private final int ranking;
    private final int count;
    private final int reward;
    private final List<Boolean> bonusMatchCases;

    WinningRank(int ranking, int count, int reward, List<Boolean> bonusMatchCases) {
        this.ranking = ranking;
        this.count = count;
        this.reward = reward;
        this.bonusMatchCases = bonusMatchCases;
    }

    public static WinningRank find(int count, boolean isBonusMatch) {
        if (NONE.count <= count && count < FIVE.count) {
            return NONE;
        }
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.count == count && winningRank.bonusMatchCases.contains(isBonusMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT_EXCEPTION));
    }

    @Override
    public String toString() {
        if (this.equals(TWO)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)", count, reward);
        }
        return String.format("%d개 일치 (%d원)", count, reward);
    }

    public int getRanking() {
        return ranking;
    }
}
