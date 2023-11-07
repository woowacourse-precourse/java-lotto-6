package lotto.domain;

import lotto.constant.LottoPrize;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> winningCount = new LinkedHashMap<>();
    private long totalWinningMoney;
    private double profitMargin;

    public LottoResult() {
        addPrizeCount();
        this.totalWinningMoney = 0l;
    }

    private void addPrizeCount() {
        this.winningCount.put(3, 0);
        this.winningCount.put(4, 0);
        this.winningCount.put(5, 0);
        this.winningCount.put(50, 0);
        this.winningCount.put(6, 0);
    }

    public Map<Integer, Integer> getWinningCount() {
        return winningCount;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void addWinningCount(int number) {
        if (checkLottoWinner(number)) {
            winningCount.put(number, winningCount.get(number) + 1);
        }
    }

    public void addTotalWinningMoney(int number) {
        if (checkLottoWinner(number)) {
            totalWinningMoney += LottoPrize.findPrizeMoney(number);
        }
    }

    private boolean checkLottoWinner(int number) {
        return winningCount.containsKey(number);
    }

    public void calculateProfitMargin(int money) {
        this.profitMargin = ((double) this.totalWinningMoney / money) * 100;
    }
}
