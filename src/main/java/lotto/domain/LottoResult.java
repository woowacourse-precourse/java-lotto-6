package lotto.domain;

import java.util.List;
import lotto.config.GamePrizeConfig;

public class LottoResult {
    private static final int COUNT_LENGTH = GamePrizeConfig.values().length + 1;

    private long income;
    private int[] count;

    public LottoResult(List<Integer> winningResult) {
        this.income = 0;
        this.count = new int[COUNT_LENGTH];
        countResult(winningResult);
        calculateResult();
    }

    public int getCount(int index) {
        return count[index];
    }

    private void calculateResult() {
        int winningIndex = 0;
        for (GamePrizeConfig prize : GamePrizeConfig.values()) {
            income += prize.getPrizeMoney() * count[winningIndex];
            winningIndex++;
        }
    }

    private void countResult(List<Integer> winningResult) {
        winningResult.forEach(winningIndex -> count[winningIndex]++);
    }

    public double calculateIncomeRate(int purchaseMoney) {
        return (double) income / purchaseMoney * 100;
    }
}
