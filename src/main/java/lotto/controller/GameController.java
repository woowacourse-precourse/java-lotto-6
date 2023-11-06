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

public class GameController {
    private final LottoManager lottoManager;
    private Money money;

    public GameController(final LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void run() {

        money = InputView.getMoneyInput();
        lottoManager.buyAutoLottos(money.requestLottoCount());
        OutputView.printEmpty();
        showBought();

        OutputView.printEmpty();
        WinningLotto winningLotto = InputView.getWinningInput();
        OutputView.printEmpty();

        Bonus bonus = InputView.getBonusInput();

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
