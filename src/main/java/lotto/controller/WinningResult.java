package lotto.controller;

import java.util.HashMap;
import java.util.Map;
import lotto.Lotto;
import lotto.Storage.LottoStorage;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

public class WinningResult {
    private Map<Rank, Integer> result = new HashMap<>();

    public WinningResult(WinningNumbers winningLotto, LottoStorage purchaseLotto) {
        calculateResult(winningLotto, purchaseLotto);
    }

    private void calculateResult(WinningNumbers winningLotto, LottoStorage purchaseLotto) {
        for (Lotto lotto : purchaseLotto) {
            Rank rank = winningLotto.oneCompare(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }

    public double calculateProfitRate(int amount) {
        int totalPrize = calculateTotalPrize();
        return (totalPrize / (amount * 1.0)) * 100;
    }

    @Override
    public String toString() {
        return "WinningResult{" +
                "result=" + result +
                '}';
    }
}
