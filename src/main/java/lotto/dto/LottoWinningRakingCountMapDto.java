package lotto.dto;

import lotto.domain.LottoWinningRanking;

import java.util.EnumMap;

public class LottoWinningRakingCountMapDto {
    private final EnumMap<LottoWinningRanking, Integer> winningRankingCountMap;

    public LottoWinningRakingCountMapDto(final EnumMap<LottoWinningRanking, Integer> winningRankingCountMap) {
        EnumMap<LottoWinningRanking, Integer> filteredMap = new EnumMap<>(LottoWinningRanking.class);

        for (LottoWinningRanking ranking : LottoWinningRanking.values()) {
            if (isNotNone(ranking)) {
                Integer count = winningRankingCountMap.getOrDefault(ranking, 0);
                filteredMap.put(ranking, count);
            }
        }
        this.winningRankingCountMap = filteredMap;
    }

    private static boolean isNotNone(final LottoWinningRanking ranking) {
        return ranking != LottoWinningRanking.NONE;
    }

    public EnumMap<LottoWinningRanking, Integer> getWinningRankingCountMap() {
        return winningRankingCountMap;
    }
}
