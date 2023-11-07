package lotto.model.result;

import static lotto.utils.Constant.MIN_MONEY;

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
        return prizeResult.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public double calculatePrizeProfit(int amount) {
        return (calculatePrizeMoney() / calculateMoneyFromAmount(amount)) * 100;
    }

    private int calculateMoneyFromAmount(int amount) {
        return amount * MIN_MONEY.getValue();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("로또 당첨 결과 객체\n");
        for (Map.Entry<Prize, Integer> entry : prizeResult.entrySet()) {
            builder.append(entry.getKey()).append(": ").append(entry.getValue()).append("개\n");
        }
        return builder.toString();
    }
}
