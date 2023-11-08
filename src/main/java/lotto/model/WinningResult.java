package lotto.model;

import java.util.Map;

public record WinningResult(Map<Rank, Integer> winningStatistics, Double winningRate) {

}