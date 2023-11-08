package lotto.domain;

import static lotto.constants.Value.ZERO;

import java.util.LinkedHashMap;
import lotto.constants.LottoPrize;

public class LottoResult {
    private double totalPrice;
    private LinkedHashMap<LottoPrize, Integer> statistics;

    public LottoResult() {

        totalPrice = ZERO.get();
        statistics = new LinkedHashMap<>();
        init();
    }

    public LinkedHashMap<LottoPrize, Integer> getStatistics() {
        return statistics;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void save(LottoPrize prize) {
        countLottoPrize(prize);
        addTotalPrice(prize);
    }

    public double calculateEarningRate(int amount) {
        return totalPrice / amount * 100;
    }

    private void init() {
        for (LottoPrize prize : LottoPrize.values()) {
            statistics.put(prize, ZERO.get());
        }
    }

    private void countLottoPrize(LottoPrize prize) {
        int number = statistics.get(prize) + 1;
        statistics.replace(prize, number);
    }

    private void addTotalPrice(LottoPrize prize) {
        totalPrice += prize.getPrice();
    }

}
