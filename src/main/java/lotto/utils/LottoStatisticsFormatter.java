package lotto.utils;

import lotto.model.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatisticsFormatter {

    public static List<String> formatStatistics(Map<LottoRank, Integer> resultMap) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .sorted()
                .map(rank -> formatRankLine(rank, resultMap.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
    }

    private static String formatRankLine(LottoRank rank, int count) {
        return String.format(rank.getDisplayFormat(), rank.getMatchCount(), rank.getWinningAmount(), count);
    }
}
