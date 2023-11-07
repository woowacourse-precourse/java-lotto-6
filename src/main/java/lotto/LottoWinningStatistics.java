package lotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class LottoWinningStatistics {
  private final Map<LottoRank, Integer> statistics;

  public LottoWinningStatistics() {
    statistics = new EnumMap<>(LottoRank.class);
    for (LottoRank rank : LottoRank.values()) {
      statistics.put(rank, 0);
    }
  }

  public void recordWinningRank(LottoRank rank) {
    statistics.put(rank, statistics.get(rank) + 1);
  }

  public int getCount(LottoRank rank) {
    return statistics.getOrDefault(rank, 0);
  }

  public long getTotalPrize() {
    return statistics.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
  }


}
