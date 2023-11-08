package lotto.dto;

import lotto.domain.LottoWinningRanking;

import java.util.EnumMap;

public class LottoWinningRakingCountMapDto {
    private final EnumMap<LottoWinningRanking, Integer> winningRankingCountMap;

    public LottoWinningRakingCountMapDto(final EnumMap<LottoWinningRanking, Integer> winningRankingCountMap) {
        this.winningRankingCountMap = winningRankingCountMap;
    }

    public EnumMap<LottoWinningRanking, Integer> getWinningRankingCountMap() {
        return winningRankingCountMap;
    }
}
