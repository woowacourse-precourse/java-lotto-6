package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record LottoResult(
        Map<Rank, Integer> result
) {
    public static LottoResult of(Map<Rank, Integer> result) {
        return new LottoResult(result);
    }

    public List<Map.Entry<Rank, Integer>> getSortedResultList() {
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(Rank::ordinal).reversed()))
                .collect(Collectors.toList());
    }
}
