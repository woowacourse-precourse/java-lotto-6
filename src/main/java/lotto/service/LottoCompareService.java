package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;

public class LottoCompareService {
    private final Lottos lottos;
    private final WinningNumber winningNumber;

    public LottoCompareService(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public void compareLottosToWinningNumber() {
    }
}
