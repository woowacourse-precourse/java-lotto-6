package lotto.domain;

public class LottoGame {
    private final LottoStore lottoStore;

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public LottoGame(LottoStore lottoStore, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.lottoStore = lottoStore;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}
