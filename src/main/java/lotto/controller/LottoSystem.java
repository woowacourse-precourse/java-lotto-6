package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;
import lotto.verifier.RuntimeVerifier;

public class LottoSystem {

    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;
    private final RuntimeVerifier runtimeVerifier = new RuntimeVerifier();

    public void run() {

        initialize();
        SettlementSystem settlementSystem = new SettlementSystem();
        settlementSystem.makeResult(winningLotto, userLotto, bonusNumber);
        settlementSystem.renderResult();

    }

    private void initialize() {
        userLotto = new UserLotto();
        winningLotto = new WinningLotto();
        while (true) {
            try {
                bonusNumber = new BonusNumber();
                runtimeVerifier.checkBonusNumberExistsInWinningLotto(winningLotto, bonusNumber);
                return;
            } catch (IllegalStateException e) {
                OutputView.printMessage(e.getMessage());
            }
        }

    }


}
