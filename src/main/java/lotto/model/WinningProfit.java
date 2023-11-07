package lotto.model;

import java.util.Map.Entry;

public class WinningProfit {

    private final int profit;

    public WinningProfit(final WinningStatics statics) {
        this.profit = getWinningProfit(statics);
    }

    public int getProfit() {
        return profit;
    }

    private int getWinningProfit(final WinningStatics statics) {
        return statics.getStatics()
                .entrySet()
                .stream()
                .mapToInt(this::getProfit)
                .sum();
    }

    private int getProfit(final Entry<WinningGrade, Integer> entry) {
        return entry.getKey().getWinningPrice() * entry.getValue();
    }

}
