package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.Rank;

public class LottoResult {

    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private final Map<Rank, Long> results = new EnumMap<>(Rank.class);

    public LottoResult(WinningLotto winningLotto, Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        initData();
        putRankData();
    }

    private void initData() {
        Arrays.stream(Rank.values()).forEach(rank ->
                results.put(rank, 0L));
    }

    private void putRankData() {
        results.putAll(lottos.tickets().stream()
                .map(winningLotto::getRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()))
        );
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
