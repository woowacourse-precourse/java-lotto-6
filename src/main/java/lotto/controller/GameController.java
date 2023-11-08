package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.LottoManager;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.dto.AutoLottoDto;
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
        showBought();

        WinningLotto winningLotto = inputView.getWinningInput();
        OutputView.printEmpty();
        Bonus bonus = inputView.getBonusInput();

        lottoManager.createWinning(winningLotto, bonus);
        showResult();
    }

    private void showBought() {
        OutputView.printEmpty();
        OutputView.printAutoLottos(AutoLottoDto.fromEnity(lottoManager.getAutoLottos()), lottoManager.getLottoCount());
        OutputView.printEmpty();
    }

    private void showResult() {
        OutputView.printEmpty();
        List<LottoRank> resultLottoToRank = lottoManager.judgeRankByLotto();
        HashMap<LottoRank, Integer> countPerRank = lottoManager.totalCountPerRank(resultLottoToRank);
        OutputView.printResultCount(countPerRank);
        double rateOfReturn = LottoCaclulator.calculateRateOfReturn(countPerRank, money.getMoney());
        OutputView.printRateOfResult(rateOfReturn);
    }

}
