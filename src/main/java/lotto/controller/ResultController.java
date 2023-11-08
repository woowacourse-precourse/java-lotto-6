package lotto.controller;

import java.util.List;
import lotto.domain.Award;
import lotto.domain.BonusNumber;
import lotto.domain.ClientLotto;
import lotto.domain.WinningLotto;
import lotto.service.AwardService;
import lotto.view.OutputView;

public class ResultController {
    private List<Award> awards;
    private float yield;

    public void makeResults(WinningLotto winningLotto, ClientLotto userLotto, BonusNumber bonusNumber) {
        awards = AwardService.makeAwards(winningLotto, userLotto, bonusNumber);
        yield = AwardService.makeYield(awards);
    }

    public void printResult() {
        OutputView.printAward(awards);
        OutputView.printYield(yield);
    }
}
