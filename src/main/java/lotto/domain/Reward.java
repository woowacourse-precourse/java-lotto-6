package lotto.domain;

import java.util.Arrays;

public enum Reward {
    REWARD3(3, 5000),
    REWARD4(4, 50000),
    REWARD5(5, 1_500_000),
    REWARD5_WITH_BONUS(6, 30_000_000),
    REWARD6(7, 2_000_000_000);

    private Integer countNum;
    private int rewardPrice;

    private Reward(int countNum, int rewardPrice) {
        this.countNum = countNum;
        this.rewardPrice = rewardPrice;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }
    public static Reward findByCountNum(int count) {

        return Arrays.stream(Reward.values())
                .filter(reward -> reward.countNum.equals(count))
                .findAny()
                .orElse(REWARD3);
    }

}