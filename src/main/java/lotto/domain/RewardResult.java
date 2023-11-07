package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class RewardResult {
    private final Map<Reward, Integer> rewardResult;

    public RewardResult() {
        rewardResult = new EnumMap<Reward, Integer>(Reward.class);
        Arrays.stream(Reward.values())
                .forEach(reward -> rewardResult.put(reward, 0));
    }

    public void calcRewardResult(Lotto winningNumber, BonusNumber bonusNumber, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Reward reward = Reward.getReward(lotto.getMatchLottoNumber(winningNumber),
                    lotto.isContain(bonusNumber.getBonusNumber()));
            updateRewardCount(reward);
        }
    }

    private void updateRewardCount(Reward reward) {
        rewardResult.put(reward, rewardResult.get(reward) + 1);
    }

    public Integer getRewardCount(Reward reward) {
        return rewardResult.get(reward);
    }
}