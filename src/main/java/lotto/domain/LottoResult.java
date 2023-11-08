package lotto.domain;

import static lotto.constants.Value.ZERO;

import java.util.HashMap;
import lotto.constants.LottoPrize;

public class LottoResult {
    private double totalPrice;
    private HashMap<LottoPrize, Integer> status;

    public LottoResult() {
        totalPrice = ZERO.get();
        status = new HashMap<>();
        init();
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
            status.put(prize, ZERO.get());
        }
    }

    private void countLottoPrize(LottoPrize prize) {
        int number = status.get(prize) + 1;
        status.replace(prize, number);
    }

    private void addTotalPrice(LottoPrize prize) {
        totalPrice += prize.getPrice();
    }

}
