package lotto.domain;

import java.util.List;

public class LottoStore {
    private final List<Lotto> lottos;

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> play(WinningNumber winningNumber) {
        return lottos.stream()
                .map(winningNumber::countWin)
                .toList();
    }

    public List<Boolean> checkBonus(BonusNumber bonusNumber) {
        return lottos.stream()
                .map(bonusNumber::checkBonus)
                .toList();
    }
}
