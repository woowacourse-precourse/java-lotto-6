package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final String NOT_EXISTE_RANK_MESSAGE = "당첨 등급이 존재하지 않습니다.";
    private int matchCount;
    private int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public Money getReward() {
        return new Money(reward);
    }

    public static Rank getRating(final int matchCount, final boolean containBonusBall) {
        if (onlyMatchThreeNumbers(matchCount, containBonusBall)) {
            return THIRD;
        }

        if (isNotWinning(matchCount)) {
            return MISS;
        }

        return Arrays.stream(values())
                .filter(rating -> rating.matchCount == matchCount)
                .findAny()
                .orElseThrow(() -> new IllegalStateException(NOT_EXISTE_RANK_MESSAGE));
    }

    public String showMessageWithCount(int count) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(this.matchCount).append("개 일치");

        if (this == Rank.SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        return stringBuilder.append(" (").append(getReward()).append(")")
                .append(" - ").append(count).append("개").toString();
    }

    private static boolean isNotWinning(int matchCount) {
        return matchCount < FIFTH.matchCount;
    }

    private static boolean onlyMatchThreeNumbers(int matchCount, boolean containBonusBall) {
        return matchCount == THIRD.matchCount && !containBonusBall;
    }
}
