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
            rewards.put(reward, rewards.get(reward) + 1);
        }
        return new GameResultResponse(rewards, computeProfit(income, payment));
    }

    private String computeProfit(int income, int payment){
        return String.format("%.1f", ((double) income / payment) * 100);
    }

    private static EnumMap<Reward, Integer> setUp() {
        EnumMap<Reward, Integer> rewards = new EnumMap<>(Reward.class);
        for (Reward reward: Reward.values()) {
            rewards.computeIfAbsent(reward, k -> 0);
        }
        return rewards;
    }
}