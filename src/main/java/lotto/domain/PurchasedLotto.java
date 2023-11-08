package lotto.domain;

import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> lottos;

    public PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> createGamePrizeIndexValues(Lotto winningLotto, BonusNumber number) {
        return lottos.stream()
                .map(lotto -> lotto.compareWinningNumber(winningLotto, number))
                .toList();
    }
}
