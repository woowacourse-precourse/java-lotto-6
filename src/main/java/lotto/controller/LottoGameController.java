package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningResult;
import lotto.dto.LottoBonusNumberCreateRequest;
import lotto.dto.LottoPurchaseRequest;
import lotto.dto.LottoWinningNumberCreateRequest;
import lotto.dto.LottoWinningStatistics;
import lotto.service.LottoGameService;
import lotto.view.LottoGameView;

public class LottoGameController {
    private final LottoGameService lottoGameService;
    private final LottoGameView lottoGameView;

    public LottoGameController(LottoGameService lottoGameService, LottoGameView lottoGameView) {
        this.lottoGameService = lottoGameService;
        this.lottoGameView = lottoGameView;
    }

    public void run() {
        purchaseLotto();
        createLottoWinningNumber();
        createLottoBonusNumber();
        printLottoWinningResult();
    }

    private void printLottoWinningResult() {
        LottoWinningResult lottoWinningResult = lottoGameService.calculateLottoWinningResult();
        lottoGameView.printWinningStatistics(new LottoWinningStatistics(
                lottoWinningResult.calculateRewardRatio(),
                lottoWinningResult.getTable()));
    }

    private void createLottoBonusNumber() {
        while (true) {
            try {
                LottoBonusNumberCreateRequest lottoBonusNumberCreateRequest =
                        lottoGameView.inputLottoBonusNumberCreateRequest();
                lottoGameService.createLottoBonusNumber(lottoBonusNumberCreateRequest);
                return;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
    }

    private void createLottoWinningNumber() {
        while (true) {
            try {
                LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest = lottoGameView.inputLottoWinningNumberCreateRequest();
                lottoGameService.createLottoWinningNumber(lottoWinningNumberCreateRequest);
                return;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
    }


    private void purchaseLotto() {
        while (true) {
            try {
                LottoPurchaseRequest lottoPurchaseRequest = lottoGameView.inputPurchaseRequest();
                List<Lotto> lottoTickets = lottoGameService.createLottoPurchase(lottoPurchaseRequest);
                lottoGameView.printPurchasedTickets(lottoTickets);
                return;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }

    }

}
