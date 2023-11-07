package lotto.domain;

import java.util.List;

public class LottoManager {
    private WinningDetails winningDetails;
    private WinningLotto winningLotto;

    private LottoManager(WinningDetails winningDetails) {
        this.winningDetails = winningDetails;
    }

    public static LottoManager from(WinningDetails winningDetails) {
        return new LottoManager(winningDetails);
    }
}
