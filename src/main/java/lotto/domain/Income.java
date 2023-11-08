package lotto.domain;

import java.util.List;
import lotto.config.GamePrizeConfig;

public class Income {
    private static final int GAME_PRIZE_NUMBER = GamePrizeConfig.values().length + 1;

    private long income;
    private final int[] count;

    public Income(List<Integer> gamePrizeIndexValues) {
        this.income = 0;
        this.count = new int[GAME_PRIZE_NUMBER];
        countGamePrizeIndexValues(gamePrizeIndexValues);
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

    private void countGamePrizeIndexValues(List<Integer> winningResult) {
        winningResult.forEach(winningIndex -> count[winningIndex]++);
    }

    public double calculateIncomeRate(int purchaseMoney) {
        return (double) income / purchaseMoney * 100;
    }
}
