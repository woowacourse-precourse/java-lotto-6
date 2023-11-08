package lotto.manager;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.ResultLotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

public class AwardManager {
    private List<ResultLotto> result;
    private float yield;

    public void makeResult(UserLotto userLotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        ResultManager resultManager = new ResultManager();
        YieldManager yieldManager = new YieldManager();

        result = resultManager.match(winningLotto, userLotto, bonusNumber);
        yield = yieldManager.makeYield(result);

    }

    public void printYield() {
        OutputView.printReward(result);
        OutputView.printYield(yield);
    }
}
