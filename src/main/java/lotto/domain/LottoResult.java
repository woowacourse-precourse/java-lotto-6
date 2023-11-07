package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.Rank;

public class LottoResult {

    private static final Long INIT_VALUE = 0L;

    private final Map<Rank, Long> results = new EnumMap<>(Rank.class);

    private LottoResult(Map<Rank, Long> results) {
        initData();
        this.results.putAll(results);
    }

    public static LottoResult of(WinningLotto winningLotto, Lottos lottos) {
        return new LottoResult(lottos.tickets().stream()
                .map(lotto -> Rank.of(winningLotto, lotto))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()))
        );
    }

    private void initData() {
        Arrays.stream(Rank.values()).forEach(rank ->
                results.put(rank, INIT_VALUE));
    }

    public Map<Rank, Long> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public double getTotalPrize() {
        return results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().prize * entry.getValue())
                .sum();
    }
}
