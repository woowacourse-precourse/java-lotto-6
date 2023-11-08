package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Reward {
    FIFTH(5_000, "3개 일치 (5,000원)",
            (matchCount, isBonus) -> matchCount == 3),
    FOURTH(50_000, "4개 일치 (50,000원)",
            (matchCount, isBonus) -> matchCount == 4),
    THIRD(1_500_000, "5개 일치 (1,500,000원)",
            (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)",
            (matchCount, isBonus) -> matchCount == 5 && isBonus),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)",
            (matchCount, isBonus) -> matchCount == 6);

    private final int rewardMoney;
    private final String description;
    private final BiPredicate<Integer, Boolean> isRewardMatch;

    Reward(int rewardMoney, String description, BiPredicate<Integer, Boolean> isRewardMatch) {
        this.rewardMoney = rewardMoney;
        this.description = description;
        this.isRewardMatch = isRewardMatch;
    }

    public static Reward valueOf(int matchCount, boolean isBonus) {
        return Arrays.stream(values())
                .filter(reward -> reward.isRewardMatch.test(matchCount, isBonus))
                .findFirst()
                .orElse(null);
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public String getDescription() {
        return description;
    }
}
