package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.dto.GameResultResponse;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public GameResultResponse match(List<Integer> luckyNumbers, int bonusNumber, int payment){
        int income = 0;
        EnumMap<Reward, Integer> rewards = setUp();
        for (Lotto lotto : lottos) {
            Reward reward = lotto.match(luckyNumbers, bonusNumber);
            income += reward.getMoney();
            computeRank(rewards, reward);
        }
        return new GameResultResponse(rewards, computeProfit(income, payment));
    }

    private static void computeRank(EnumMap<Reward, Integer> totalReward, Reward reward) {
        Integer matchNumber = totalReward.get(reward);
        totalReward.put(reward, matchNumber + 1);
    }

    private String computeProfit(int income, int payment){
        return String.format("%.1f", ((double) income / payment) * 100);
    }

    private static EnumMap<Reward, Integer> setUp() {
        EnumMap<Reward, Integer> totalReward = new EnumMap<Reward, Integer>(Reward.class);
        for (Reward reward: Reward.values()) {
            totalReward.computeIfAbsent(reward, k -> 0);
        }
        return totalReward;
    }
}
