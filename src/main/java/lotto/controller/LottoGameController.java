package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningResult;
import lotto.dto.LottoBonusNumberCreateRequest;
import lotto.dto.LottoPurchaseRequest;
import lotto.dto.LottoResponse;
import lotto.dto.LottoWinningNumberCreateRequest;
import lotto.dto.LottoWinningStatistics;
import lotto.exception.ExceptionHandlingStrategy;
import lotto.service.LottoGameService;
import lotto.view.LottoGameView;

public class LottoGameController {
    private final LottoGameService lottoGameService;
    private final LottoGameView lottoGameView;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;

    public LottoGameController(LottoGameService lottoGameService, LottoGameView lottoGameView,
                               ExceptionHandlingStrategy exceptionHandlingStrategy) {
        this.lottoGameService = lottoGameService;
        this.lottoGameView = lottoGameView;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
    }

    public void run() {
        purchaseLotto();
        createLottoWinningNumber();
        createLottoBonusNumber();
        printLottoWinningStatistics();
    }

    private void printLottoWinningStatistics() {
        LottoWinningResult lottoWinningResult = lottoGameService.calculateLottoWinningResult();
        lottoGameView.printWinningStatistics(LottoWinningStatistics.from(lottoWinningResult));
    }

    private void createLottoBonusNumber() {
        exceptionHandlingStrategy.apply(lottoGameView, lottoGameService,
                (view, service) -> {
                    LottoBonusNumberCreateRequest lottoBonusNumberCreateRequest =
                            view.inputLottoBonusNumberCreateRequest();
                    service.createLottoBonusNumber(lottoBonusNumberCreateRequest);
                });
    }

    private void createLottoWinningNumber() {
        exceptionHandlingStrategy.apply(lottoGameView, lottoGameService,
                (view, service) -> {
                    LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest =
                            view.inputLottoWinningNumberCreateRequest();
                    service.createLottoWinningNumber(lottoWinningNumberCreateRequest);
                });
    }


    private void purchaseLotto() {
        exceptionHandlingStrategy.apply(lottoGameView, lottoGameService,
                (view, service) -> {
                    LottoPurchaseRequest lottoPurchaseRequest = view.inputPurchaseRequest();
                    List<Lotto> lottoTickets = service.createLottoPurchase(lottoPurchaseRequest);
                    List<LottoResponse> lottoResponses = lottoTickets.stream()
                            .map(LottoResponse::from)
                            .toList();
                    view.printPurchasedTickets(lottoResponses);
                });
    }

}
