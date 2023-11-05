package lotto.domain;

import lotto.constant.WinningGrade;

import java.util.EnumMap;
import java.util.Map;

public final class WinningResult {

    private final Map<WinningGrade, Integer> results;

    public WinningResult(final Map<WinningGrade, Integer> results) {
        this.results = new EnumMap<>(WinningGrade.class);
        this.results.putAll(results);
    }

    public int numOfWinningGrade(final WinningGrade winningGrade) {
        return results.get(winningGrade);
    }
}
