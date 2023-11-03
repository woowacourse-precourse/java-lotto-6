package lotto.domain.lotto;

import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public List<LottoReward> createCompareResults(final Lotto winningLotto, final int bonusNumber) {
        return lottos.stream()
                .map(userLotto -> LottoReward.getCompareResult(userLotto, winningLotto, bonusNumber))
                .toList();
    }
}
