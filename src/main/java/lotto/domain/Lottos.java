package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.GameConstant;
import lotto.dto.GameResultResponse;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public GameResultResponse match(List<Integer> luckyNumbers, int bonusNumber, int payment){
        int income = 0;
        Map<Integer, Integer> totalReward = setUp();
        for (Lotto lotto : lottos) {
            Reward reward = compute(lotto.match(luckyNumbers, bonusNumber));
            income += reward.getMoney();
            computeRank(totalReward, reward.getRank());
        }
        return new GameResultResponse(totalReward, computeProfit(income, payment));
    }

    private static void computeRank(Map<Integer, Integer> totalReward, int rank) {
        if (totalReward.get(rank) != null) {
            int matchNumber = totalReward.get(rank);
            totalReward.put(rank, matchNumber + 1);
        }
    }

    private double computeProfit(int income, int payment){
        String profit = String.format("%.1f", ((double) income / payment) * 100);
        return Double.parseDouble(profit);
    }

    private static Map<Integer, Integer> setUp() {
        Map<Integer, Integer> totalReward = new HashMap<>();
        for (int i = GameConstant.FIRST_RANK; i <= GameConstant.FIFTH_RANK; i++) {
            totalReward.computeIfAbsent(i, k -> 0);
        }
        return totalReward;
    }

    private Reward compute(Map<String, Integer> matchResult){
        return Reward.computer(matchResult.get(GameConstant.LUCKY_NUMBERS),
                matchResult.get(GameConstant.BONUS_NUMBER));
    }
}
