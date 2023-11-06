package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public record Lottos(List<Lotto> lottos) {

    @Override
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<LottoRewardCondition> createCompareResults(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::findCompareResult)
                .toList();
    }
}
