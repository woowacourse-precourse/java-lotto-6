package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.LottoManager;
import lotto.domain.MatchNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.utils.LottoCaclulator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Viewable;

public class GameController {
    private final LottoManager lottoManager;
    private Money money;
    private static final Viewable inputView = new InputView().getInstance();

    public GameController(final LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void run() {

        money = inputView.getMoneyInput();
        lottoManager.buyAutoLottos(money.requestLottoCount());
        OutputView.printEmpty();
        showBought();

        OutputView.printEmpty();
        WinningLotto winningLotto = inputView.getWinningInput();
        OutputView.printEmpty();

        Bonus bonus = inputView.getBonusInput();

        lottoManager.createWinning(winningLotto, bonus);
        OutputView.printEmpty();
        showResult();

    }

    private void showBought() {
        OutputView.printAutoLottos(lottoManager.getAutoLottos(), lottoManager.getLottoCount());
    }

    private void showResult() {
        List<MatchNumber> matchs = lottoManager.judgeMatchNumberByLotto();
        List<Integer> matchCount = lottoManager.totalMatchNumber(matchs);
        OutputView.printResultCount(matchCount);
        double rateOfReturn = LottoCaclulator.calculateRateOfReturn(matchCount, money.getMoney());
        OutputView.printRateOfResult(rateOfReturn);
    }

}
