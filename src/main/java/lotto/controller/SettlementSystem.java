package lotto.controller;

import lotto.domain.Award;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.io.OutputHandler;
import lotto.manager.AwardManager;


import java.util.List;

public class SettlementSystem {

    private List<Award> awards;

    public void makeResult(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        awards = AwardManager.makeAwards(winningLotto, userLotto, bonusNumber);
    }

    public void renderResult() {
        OutputHandler.printReward(awards);
    }
}
