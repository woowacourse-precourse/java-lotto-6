package lotto.controller;

import lotto.IO.Input;
import lotto.model.LottoGameManager;
import lotto.model.RankingManager;
import lotto.view.View;

public class LottoGameController {
    private final View view;
    private final LottoGameManager lottoGameManager;
    private final RequestController lottoCostController;
    private final RequestController winningNumbersController;
    private final RequestController bonusNumberController;
    private RankingManager rankingManager;

    public LottoGameController() {
        this.view = getView();
        this.lottoGameManager = getLottoGameManager();
        this.lottoCostController = getLottoCostController();
        this.winningNumbersController = getWinningNumbersController();
        this.bonusNumberController = getBonusNumberController();
    }

    public void gameStart() {
        lottoCostController.requestProcess();
        winningNumbersController.requestProcess();
        bonusNumberController.requestProcess();
        responseGameResult();
    }

    private void responseGameResult() {
        rankingManager = lottoGameManager.generateRankingManager();
        responseWinningDetails();
        responseEarningsRate();
    }

    private void responseWinningDetails() {
        view.outputWinningDetails(rankingManager.getWinningDetails());
    }

    private void responseEarningsRate() {
        view.outputEarningsRate(rankingManager.calculateEarningsRate());
    }

    private View getView() {
        return new View(new Input());
    }

    private LottoGameManager getLottoGameManager() {
        return new LottoGameManager();
    }

    private LottoCostController getLottoCostController() {
        return new LottoCostController(view, lottoGameManager);
    }

    private WinningNumbersController getWinningNumbersController() {
        return new WinningNumbersController(view, lottoGameManager);
    }

    private BonusNumberController getBonusNumberController() {
        return new BonusNumberController(view, lottoGameManager);
    }
}
