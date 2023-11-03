package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.dto.LottoResult;

public class LottoTotalResult {

    private static final int INITIAL_COUNT = 0;

    private final Map<LottoRank, Integer> totalResult;

    private LottoTotalResult(final Map<LottoRank, Integer> result) {
        this.totalResult = result;
    }

    public static LottoTotalResult createDefault() {
        Map<LottoRank, Integer> totalResult = new HashMap<>();
        Arrays.stream(LottoRank.values())
            .forEach(lottoRank -> {
                totalResult.put(lottoRank, INITIAL_COUNT);
            });
        return new LottoTotalResult(totalResult);
    }

    public void reflectCompareResult(final LottoCompareResult compareResult) {
        Optional<LottoRank> rank = compareResult.getResultRank();

        if (rank.isEmpty()) {
            return;
        }

        totalResult.compute(rank.get(), (rankKey, count) -> count + 1);
    }

    public long getSum() {
        return totalResult.keySet()
            .stream()
            .mapToLong(lottoRank -> lottoRank.getReward() * totalResult.get(lottoRank))
            .sum();
    }

    public List<LottoResult> toDto() {
        return totalResult.keySet()
            .stream()
            .map(lottoRank -> LottoResult.of(lottoRank, totalResult.get(lottoRank)))
            .sorted(Comparator.comparing(LottoResult::reward))
            .toList();
    }
}
