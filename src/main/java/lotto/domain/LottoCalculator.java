package lotto.domain;

import static lotto.constant.LottoInformation.LOTTO_PRICE;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Map;
import lotto.constant.Prize;

public class LottoCalculator {
    private final Map<Prize, Integer> result;

    public LottoCalculator(Map<Prize, Integer> result) {
        this.result = result;
    }

    public String calculateProfitRate() {
        int money = calculateTotalSpent();
        long totalPrize = calculateTotalPrize();
        if (totalPrize == 0) {
            return "0.0";
        }
        double profit = ((double) totalPrize / money) * 100;
        profit = Math.round(profit * 10) / 10.0;
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(profit);
    }

    public long calculateTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry ->
                        (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public int calculateTotalSpent() {
        int count = result.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        return count * LOTTO_PRICE;
    }

    public Map<Prize, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
