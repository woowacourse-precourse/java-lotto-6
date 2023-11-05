package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        WinningLotto winningLotto = readWinningLotto();
    }

    private WinningLotto readWinningLotto() {
        Lotto lotto = readLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        return createWinningLotto(lotto, bonusNumber);
    }

    private WinningLotto createWinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        try {
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            return createWinningLotto(lotto, readBonusNumber());
        }
    }

    private Lotto readLottoNumbers() {
        try {
            return new Lotto(InputView.readLottoNumbers());
        } catch (IllegalArgumentException e) {
            return readLottoNumbers();
        }
    }

    private LottoNumber readBonusNumber() {
        try {
            return new LottoNumber(InputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            return readBonusNumber();
        }
    }
}
