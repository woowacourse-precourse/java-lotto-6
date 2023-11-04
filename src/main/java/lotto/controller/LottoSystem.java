package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;

public class LottoSystem {

    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void run() {

        initialize();
        SettlementSystem settlementSystem = new SettlementSystem();
        settlementSystem.makeResult(winningLotto, userLotto, bonusNumber);
        settlementSystem.renderResult();

    }

    private void initialize() {
        userLotto = new UserLotto();
        winningLotto = new WinningLotto();
        bonusNumber = new BonusNumber();
    }


}
