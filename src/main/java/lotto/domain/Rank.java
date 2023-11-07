package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    NONE(0, 0, List.of(true, false)),
    FIVE(3, 5000, List.of(true, false)),
    FOUR(4, 50000, List.of(true, false)),
    THREE(5, 1500000, List.of(false)),
    TWO(5, 30000000, List.of(true)),
    ONE(6, 2000000000, List.of(true, false));

    private static final String INVALID_COUNT_EXCEPTION = "존재하지 않는 당첨 개수입니다.";
    private static final String RANK_CONDITION_FORMAT = "%d개 일치 (%,d원)";
    private static final String RANK_CONDITION_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원)";

    private final int matchCount;
    private final int reward;
    private final List<Boolean> bonusMatchCases;

    Rank(int matchCount, int reward, List<Boolean> bonusMatchCases) {
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

    public int calculateReward(int number) {
        return this.reward * number;
    }

    @Override
    public String toString() {
        String format = RANK_CONDITION_FORMAT;
        if (this.equals(TWO)) {
            format = RANK_CONDITION_WITH_BONUS_FORMAT;
        }
        return String.format(format, matchCount, reward);
    }
}
