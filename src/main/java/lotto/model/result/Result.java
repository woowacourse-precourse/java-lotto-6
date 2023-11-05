package lotto.model.result;

import static lotto.constants.Rule.MIN_MONEY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Winning;

public class Result {
    private final Map<Prize, Integer> prizeResult = new HashMap<>();

    private Result(List<Lotto> playerLotto, Winning winning) {
        for (Lotto lotto : playerLotto) {
            Prize prize = Prize.valueOf(lotto.countMatchNumbers(winning), lotto.isMatchNumber(winning.getBonus()));
            addPrizeResult(prize);
        }
    }

    public static Result of(List<Lotto> playerLotto, Winning winning) {
        return new Result(playerLotto, winning);
    }

    private void addPrizeResult(Prize prize) {
        prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1);
    }

    public int getPrizeCount(Prize prize) {
        return prizeResult.getOrDefault(prize, 0);
    }

    public double calculatePrizeMoney() {
        double total = 0;
        for (Prize prize : prizeResult.keySet()) {
            total += prize.getPrizeMoney() * prizeResult.get(prize);
        }
        return total;
    }

    public double calculatePrizeProfit(int amount) {
        int money = amount * MIN_MONEY.getValue();
        return (calculatePrizeMoney() / money) * 100;
    }
}
