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
        this.lottoCostController = new LottoCostController(view, lottoGameManager);
        this.winningNumbersController = new WinningNumbersController(view, lottoGameManager);
        this.bonusNumberController = new BonusNumberController(view, lottoGameManager);
    }

    public void gameStart() {
        lottoCostController.requestProcess();
        winningNumbersController.requestProcess();
        bonusNumberController.requestProcess();
        responseGameResult();
    }

    public void responseGameResult() {
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
}
