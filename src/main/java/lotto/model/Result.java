package lotto.model;

import static lotto.constants.Rule.MIN_MONEY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public double calculateProfit(int amount) {
        int money = amount * MIN_MONEY.getValue();
        return (calculatePrizeMoney() / money) * 100;
    }
}
