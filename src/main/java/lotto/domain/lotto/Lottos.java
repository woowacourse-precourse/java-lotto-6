package lotto.domain.lotto;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public List<LottoRewardCondition> createCompareResults(final Lotto winningLotto, final int bonusNumber) {
        return lottos.stream()
                .map(userLotto -> LottoRewardCondition.getCompareResult(userLotto, winningLotto, bonusNumber))
                .toList();
    }
}
