package lotto.controller;

import lotto.manager.AwardManager;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;

public class LottoController {

    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void run() {

        initialize();

        AwardManager awardManager = new AwardManager();
        awardManager.makeResult(userLotto, winningLotto, bonusNumber);
        awardManager.printYield();
    }

    private void initialize() {
        userLotto = new UserLotto();
        winningLotto = new WinningLotto();
        bonusNumber = new BonusNumber();
    }
}
