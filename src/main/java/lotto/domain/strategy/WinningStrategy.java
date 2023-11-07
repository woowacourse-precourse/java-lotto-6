package lotto.domain.strategy;

import lotto.domain.WinningStatistics;

import java.util.Map;

public interface WinningStrategy {
    void apply(Map<WinningStatistics, Integer> totalStatistics);
}
