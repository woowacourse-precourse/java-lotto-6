package lotto.domain.lotto;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public List<LottoRewardCondition> createCompareResults(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::getCompareResult)
                .toList();
    }
}
