package lotto.controller;

import lotto.model.LottoGameManager;
import lotto.model.RankingManager;
import lotto.view.View;

public class LottoGameController {
    private final View view;
    private final LottoGameManager lottoGameManager;

    private RankingManager rankingManager;

    public LottoGameController(View view, LottoGameManager lottoGameManager) {
        this.view = view;
        this.lottoGameManager = lottoGameManager;
    }

    public void gameStart() {
        requestLottoPurchase();
        requestWiningNumbers();
        requestBonusNumber();
        responseGameResult();
    }

    private void requestLottoPurchase() {
        while (true) {
            try {
                lottoGameManager.createLottoBucket(view.inputLottoCost());
                view.outputPublishedLotto(lottoGameManager.getPublishedLotto());
                break;
            } catch (IllegalArgumentException e) {
                view.outputErrorMessage(e);
            }
        }
    }

    private void requestWiningNumbers() {
        while (true) {
            try {
                lottoGameManager.createWinningLotto(view.inputWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                view.outputErrorMessage(e);
            }
        }
    }

    private void requestBonusNumber() {
        while (true) {
            try {
                lottoGameManager.parsingBonusNumber(view.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                view.outputErrorMessage(e);
            }
        }
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
}
