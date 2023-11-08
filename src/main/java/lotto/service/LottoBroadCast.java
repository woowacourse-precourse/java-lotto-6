package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.impl.BonusNumberView;
import lotto.view.impl.WinningNumberView;

public class LottoBroadCast {
    private WinningNumberView winningNumberView;
    private BonusNumberView bonusNumberView;

    public LottoBroadCast(WinningNumberView winningNumberView, BonusNumberView bonusNumberView) {
        this.winningNumberView = winningNumberView;
        this.bonusNumberView = bonusNumberView;
    }



    public WinningLotto announceWinningLotto() {
        Lotto winningLotto = requestLottoNumber();
        BonusNumber bonusNumber = requestBonusNumber();

        return LottoGenerator.generateWinningLotto(winningLotto,bonusNumber);
    }

    private Lotto requestLottoNumber() {
        return (Lotto) winningNumberView.inputView();
    }

    private BonusNumber requestBonusNumber(){
        return (BonusNumber) bonusNumberView.inputView();
    }
}
