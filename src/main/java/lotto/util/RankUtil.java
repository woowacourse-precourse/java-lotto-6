package lotto.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public class RankUtil {
    private RankUtil() {
    }

    public static long getProfits(List<Rank> ranks) {
        validateNotEmpty(ranks);
        final Map<Rank, Long> result = getRankCountMap(ranks);
        return result.entrySet().stream().mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue()).sum();
    }

    public static void printResult(List<Rank> ranks) {
        validateNotEmpty(ranks);
        final Map<Rank, Long> result = getRankCountMap(ranks);
        System.out.println("당첨 통계");
        System.out.println("---");
        result.forEach(RankUtil::printDrawResultLine);
    }

    private static void printDrawResultLine(Rank rank, long count) {
        final String message = "%s - %d개";
        if (rank != Rank.MISS) {
            System.out.println(String.format(message, rank.getMessage(), count));
        }
    }

    private static Map<Rank, Long> getRankCountMap(List<Rank> ranks) {
        validateNotEmpty(ranks);
        return ranks.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private static void validateNotEmpty(List<Rank> ranks) {
        final String message = "추첨 결과가 없습니다.";
        if (ranks == null || ranks.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
