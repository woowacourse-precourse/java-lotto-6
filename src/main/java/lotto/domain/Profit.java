package lotto.domain;

import static lotto.condition.LottoCondition.LOTTO_PRICE;

import java.util.Map;
import lotto.dto.ProfitResponse;

public class Profit {
    private final double lottoProfit;

    private Profit(int count, Map<Integer, Integer> prizeResult) {
        int totalPrize = calculateTotalPrize(prizeResult);
        this.lottoProfit = calculateProfit(count, totalPrize);
    }

    public static Profit create(int count, Map<Integer, Integer> prizeResult) {
        return new Profit(count, prizeResult);
    }

    private static double calculateProfit(int count, int totalPrize) {
        return (double) totalPrize * 100 / (count * LOTTO_PRICE.getValue());
    }

    private static int calculateTotalPrize(Map<Integer, Integer> prizeResult) {
        return prizeResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
    }

    public ProfitResponse generateProfitResponse() {
        return new ProfitResponse(lottoProfit);
    }
}
