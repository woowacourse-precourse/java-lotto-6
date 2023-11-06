package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.GameConstant;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public void match(List<Integer> luckyNumbers, int bonusNumber){
        int money = 0;
        Map<Integer, Integer> totalReward = setUp();
        for (Lotto lotto : lottos) {
            Reward reward = compute(lotto.match(luckyNumbers, bonusNumber));
            money += reward.getMoney();
            int matchNumber = totalReward.get(reward.getRank());
            totalReward.put(reward.getRank(), matchNumber + 1);
        }
    }

    private static Map<Integer, Integer> setUp() {
        Map<Integer, Integer> totalReward = new HashMap<>();
        for (int i = 0; i <= 5; i++) {
            totalReward.computeIfAbsent(i, k -> 0);
        }
        return totalReward;
    }

    private Reward compute(Map<String, Integer> matchResult){
        int totalCount = matchResult.get(GameConstant.LUCKY_NUMBERS)+matchResult.get(GameConstant.BONUS_NUMBER);
        return Reward.computer(totalCount,
                matchResult.get(GameConstant.BONUS_NUMBER));
    }
}
