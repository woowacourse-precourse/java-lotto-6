package lotto;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.ResultLotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

public class LottoManager {

    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    private List<ResultLotto> result;
    private float yield;

    public void run() {

        initialize();

        ResultManager resultManager = new ResultManager();
        YieldManager yieldManager = new YieldManager();
        result = resultManager.match(winningLotto, userLotto, bonusNumber);
        yield = yieldManager.makeYield(result);

        OutputView.printReward(result);
        OutputView.printYield(yield);
    }

    private void initialize() {
        userLotto = new UserLotto();
        winningLotto = new WinningLotto();
        bonusNumber = new BonusNumber();
    }
}
