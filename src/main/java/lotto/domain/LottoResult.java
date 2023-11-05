package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Prize, Integer> result;

    private LottoResult(final Map<Prize, Integer> result) {
        this.result = result;
    }

    public static LottoResult of(final Lottos lottos, final WinningLotto winningLotto) {
        return new LottoResult(lottos.getLottos().stream().collect(Collectors.groupingBy(winningLotto::rankPrize,
                Collectors.summingInt(e -> 1))));
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }
}
