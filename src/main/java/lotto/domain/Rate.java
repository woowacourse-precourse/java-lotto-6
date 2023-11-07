package lotto.domain;

public class Rate {

    private final double rate;

    public Rate(Money money, RewardResult rewardResult) {
        this.rate = (getAllMoney(rewardResult) * 0.1) / money.getLottoCount();
    }

    private long getAllMoney(RewardResult rewardResult) {
        int result = 0;

        for (Reward reward : Reward.values()) {
            result += rewardResult.getRewardCount(reward) * reward.getMoney();
        }
        return result;
    }

    public double getRate() {
        return rate;
    }
}
