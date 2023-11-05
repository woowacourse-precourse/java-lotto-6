package lotto.domain;

import static lotto.constants.Rule.MIN_MONEY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result = new HashMap<>();

    private Result(List<Lotto> playerLotto, Prize prize) {
        for (Lotto lotto : playerLotto) {
            Rank rank = Rank.valueOf(lotto.countMatchNumbers(prize.getLotto()), lotto.isMatchNumber(prize.getBonus()));
            add(rank);
        }
    }

    public static Result of(List<Lotto> playerLotto, Prize prize) {
        return new Result(playerLotto, prize);
    }

    private void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getResultCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public double calculateResult() {
        double total = 0;
        for (Rank rank : result.keySet()) {
            total += rank.getPrizeMoney() * result.get(rank);
        }
        return total;
    }

    public double calculateRate(int amount) {
        int money = amount * MIN_MONEY.getValue();
        return (calculateResult() / money) * 100;
    }
}
