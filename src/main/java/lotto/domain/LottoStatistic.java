package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistic {
    private final Map<LottoResult, Long> lottoStatistic;
    public LottoStatistic(List<LottoResult> lottoResults) {
        lottoStatistic = lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<LottoResult, Long> getLottoStatistic() {
        return Map.copyOf(lottoStatistic);
    }
}
