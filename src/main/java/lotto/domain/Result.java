package lotto.domain;

import java.util.Arrays;

public enum Result {
    THREE_MATCH(3, "3개 일치", 5_000),
    FOUR_MATCH(4, "4개 일치", 50_000),
    FIVE_MATCH(5, "5개 일치", 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, "5개 일치, 보너스 볼 일치", 30_000_000),
    SIX_MATCH(6, "6개 일치", 2_000_000_000),
    ;

    private final Integer match;
    private final String content;
    private final Integer reward;

    Result(Integer match, String content, Integer reward) {
        this.match = match;
        this.content = content;
        this.reward = reward;
    }

    public static Result of(Integer matchCount, boolean isBonusMatched) {
        if (matchCount.equals(FIVE_MATCH_WITH_BONUS.reward) && isBonusMatched) return FIVE_MATCH_WITH_BONUS;
        return Arrays.stream(values())
                .filter(result -> matchCount.equals(result.match))
                .findFirst()
                .orElseThrow();
    }

    public String getContent() {
        return content;
    }

    public Integer getReward() {
        return reward;
    }
}
