package lotto.controller.dto;

import lotto.domain.LottoResults;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;

public record GameResult(List<LottoGameResult> results, double profitRate) {

    public static GameResult of(LottoResults results, double profitRate) {
        Map<Rank, Long> rankGroup = Arrays.stream(Rank.values())
                .collect(
                        groupingBy(
                                rank -> rank,
                                flatMapping(rank ->
                                                results.getRanks().stream()
                                                        .filter(result -> result.equals(rank)),
                                        counting()
                                )
                        )
                );

        return new GameResult(
                rankGroup.entrySet().stream()
                        .sorted(comparingLong(entry -> entry.getKey().getWinningMoney()))
                        .filter(entry -> entry.getKey() != Rank.MISS)
                        .map(entry -> LottoGameResult.of(entry.getKey(), entry.getValue().intValue()))
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
