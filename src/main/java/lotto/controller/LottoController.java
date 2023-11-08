package lotto.controller;

import lotto.domain.manager.AwardManager;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.validation.RuntimeValidation;

public class LottoController {
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;
    private RuntimeValidation runtimeValidation = new RuntimeValidation();

    public LottoController() {
        userLotto = new UserLotto();
        winningLotto = new WinningLotto();
        bonusNumber = new BonusNumber();
    }

    public void run() {

        runtimeValidation.runtimeCompareBounsWithWinning(bonusNumber, winningLotto);
        AwardManager awardManager = new AwardManager();
        awardManager.makeResult(userLotto, winningLotto, bonusNumber);
        awardManager.printYield();
    }

}
