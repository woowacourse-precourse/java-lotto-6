package lotto.controller.dto;

import lotto.domain.LottoResults;
import lotto.domain.Rank;

import java.util.List;

import static java.util.Comparator.comparingLong;

public record GameResult(List<LottoGameResult> results, double profitRate) {

    public static GameResult of(LottoResults results, double profitRate) {
        return new GameResult(
                results.generateRankGroup().entrySet().stream()
                        .sorted(comparingLong(entry -> entry.getKey().getWinningMoney()))
                        .filter(entry -> entry.getKey() != Rank.MISS)
                        .map(entry ->
                                LottoGameResult.of(entry.getKey(), entry.getValue().intValue())
                        )
                        .toList(),
                profitRate
        );
    }

    public record LottoGameResult(int matchCount, int winningMoney, int count) {

        private static LottoGameResult of(Rank rank, int count) {
            return new LottoGameResult(
                    rank.getMatchCount(),
                    rank.getWinningMoney(),
                    count
            );
        }

    }

}
