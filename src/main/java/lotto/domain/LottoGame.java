package lotto.domain;

import java.util.List;

public class LottoGame {
    private final LottoStore lottoStore;

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public LottoGame(LottoStore lottoStore, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.lottoStore = lottoStore;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> play() {
        return lottoStore.play(winningNumber);
    }

    public List<Boolean> checkBonus() {
        return lottoStore.checkBonus(bonusNumber);
    }
}
