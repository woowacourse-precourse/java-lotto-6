package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.policy.WinConditionPolicy;

public class Result {
    private final Map<WinConditionPolicy, Integer> winConditionAndCount; // <당첨 상태, 횟수>

    private Result(Map<WinConditionPolicy, Integer> winConditionAndCount) {
        this.winConditionAndCount = winConditionAndCount;
    }

    public static Result of(List<WinConditionPolicy> winResult) {
        Map<WinConditionPolicy, Integer> winConditionAndCount = new HashMap<>();
        for (WinConditionPolicy winCondition : WinConditionPolicy.values()) {
            winConditionAndCount.put(
                    winCondition,
                    (int) winResult.stream()
                    .filter(e -> (e == winCondition))
                    .count()
            );
        }
        return new Result(winConditionAndCount);
    }

    public double getTotalWinProfit() {
        long sum = 0;
        for (WinConditionPolicy winCondition : winConditionAndCount.keySet()) {
            sum += (winCondition.getReward()) * (winConditionAndCount.get(winCondition));
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (WinConditionPolicy winCondition : WinConditionPolicy.values()) {
            stringBuilder.append(
                    winCondition.getOutputMessage(
                            winConditionAndCount.get(winCondition)
                    ) + "\n"
            );
        }
        return stringBuilder.toString();
    }
}
