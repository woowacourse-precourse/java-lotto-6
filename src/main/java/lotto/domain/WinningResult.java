package lotto.domain;

import lotto.constant.WinningGrade;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public final class WinningResult {

    private static final int NO_WINNING_RESULT_EXISTS = 0;
    private final Map<WinningGrade, Integer> results;

    public WinningResult(final Map<WinningGrade, Integer> results) {
        this.results = new EnumMap<>(WinningGrade.class);
        this.results.putAll(results);
    }

    public int numOfWinningGrade(final WinningGrade winningGrade) {
        return Optional.ofNullable(results.get(winningGrade)).orElse(NO_WINNING_RESULT_EXISTS);
    }

    public EarningRate calculateProfit(final PurchaseAmount purchaseAmount) {
        final int profit = results.entrySet().stream().mapToInt(this::sumOfEarning).sum();
        return new EarningRate(profit, purchaseAmount);
    }

    private int sumOfEarning(final Entry<WinningGrade, Integer> entry) {
        final WinningGrade winningGrade = entry.getKey();
        return winningGrade.toPrize() * entry.getValue();
    }
}
