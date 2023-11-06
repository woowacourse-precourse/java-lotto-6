package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultLotto {
    private static final String NUMBER_COUNT = "개";
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_HUNDRED = 100;

    private final Map<Prize, Integer> result = new EnumMap<>(Prize.class);

    public ResultLotto() {
        for (Prize prize : Prize.values()) {
            result.put(prize, NUMBER_ZERO);
        }
    }

    public void addResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        Prize prize = MatchLotto.calculate(lotto, winningNumbers, bonusNumber);
        result.putIfAbsent(prize, NUMBER_ZERO);
        result.put(prize, result.get(prize) + NUMBER_ONE);
    }

    public void printResult() {
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.EMPTY)
                .forEach(prize -> System.out.println(prize.getMessage()
                        + result.getOrDefault(prize, NUMBER_ZERO) + NUMBER_COUNT));
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (calculateTotalPrize() / purchaseAmount) * NUMBER_HUNDRED;
    }

    private double calculateTotalPrize() {
        double totalPrize = 0.0;

        for (Prize prize : Prize.values()) {
            totalPrize += prize.getPrizeAmount() * result.getOrDefault(prize, NUMBER_ZERO);
        }

        return totalPrize;
    }
}
