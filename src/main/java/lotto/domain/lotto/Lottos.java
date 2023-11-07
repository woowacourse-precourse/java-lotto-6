package lotto.domain.lotto;

import lotto.constants.LottoConsts;
import lotto.domain.game.Prize;

import java.util.List;

public record Lottos(
        List<Lotto> lottos
) {
    public Lottos(List<Lotto> lottos) {
        this.lottos = makeUnmodifiable(lottos);
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private List<Lotto> makeUnmodifiable(final List<Lotto> lottos) {
        return List.copyOf(lottos);
    }

    public List<Prize> calculatePrizes(final WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> Prize.of(winningNumber.countMatch(lotto), winningNumber.checkBonusNumber(lotto)))
                .toList();
    }

    public int getPurchasingCost() {
        return lottos.size() * LottoConsts.LOTTO_PRICE.getValue();
    }
}
