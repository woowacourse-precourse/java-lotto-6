package lotto.controller;

import lotto.manager.AwardManager;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.validation.RuntimeValidation;

public class LottoController {
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;
    private RuntimeValidation runtimeValidation = new RuntimeValidation();

    public void run() {

        initialize();

        runtimeValidation.runtimeCompareBounsWithWinning(bonusNumber, winningLotto);
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
