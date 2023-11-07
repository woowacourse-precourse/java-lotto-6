package lotto.domain.statistics;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<LottoRank, Integer> winningsStatistics;

    public WinningStatistics() {
        winningsStatistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> winningsStatistics.put(rank,0));
    }

    public void updateStatistics(List<LottoResult> lottoResults) {
        lottoResults.stream()
                .filter(result -> result.getRank() != null)
                .forEach(result -> addCount(result.getRank()));
    }

    public int getCountOfRank(LottoRank rank) {
        return winningsStatistics.get(rank);
    }

    public long getPrizeMoney() {
        return Arrays.stream(LottoRank.values())
                .mapToLong(rank -> getCountOfRank(rank)* (long)rank.getPrize())
                .sum();
    }

    private void addCount(LottoRank rank) {
        int exist = winningsStatistics.get(rank);
        winningsStatistics.put(rank,++exist);
    }

}
