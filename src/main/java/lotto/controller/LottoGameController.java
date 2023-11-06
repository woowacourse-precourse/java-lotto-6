package lotto.controller;

import java.util.List;
import lotto.controller.dto.LottoBonusNumberCreateRequest;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.LottoResponse;
import lotto.controller.dto.LottoWinningNumberCreateRequest;
import lotto.controller.dto.LottoWinningStatistics;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.domain.LottoWinningResult;
import lotto.service.LottoGameService;

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
        LottoPurchase lottoPurchase = purchaseLotto();
        List<Lotto> lottoTickets = createLotto(lottoPurchase);
        LottoWinningNumber lottoWinningNumber = createLottoWinningNumber();
        LottoBonusNumber lottoBonusNumber = createLottoBonusNumber(lottoWinningNumber);
        printLottoWinningStatistics(lottoTickets, lottoPurchase, lottoWinningNumber, lottoBonusNumber);
    }

    private List<Lotto> createLotto(LottoPurchase lottoPurchase) {
        List<Lotto> lottoTickets = lottoGameService.purchaseLotto(lottoPurchase);
        List<LottoResponse> lottoResponses = lottoTickets.stream()
                .map(LottoResponse::from)
                .toList();
        lottoGameView.printPurchasedTickets(lottoResponses);
        return lottoTickets;
    }

    private void printLottoWinningStatistics(
            List<Lotto> lottoTickets,
            LottoPurchase lottoPurchase,
            LottoWinningNumber lottoWinningNumber,
            LottoBonusNumber lottoBonusNumber) {
        LottoWinningResult lottoWinningResult = lottoGameService.calculateLottoWinningResult(
                lottoTickets, lottoPurchase, lottoWinningNumber, lottoBonusNumber);
        lottoGameView.printWinningStatistics(LottoWinningStatistics.from(lottoWinningResult));
    }

    private LottoBonusNumber createLottoBonusNumber(LottoWinningNumber lottoWinningNumber) {
        return (LottoBonusNumber) exceptionHandlingStrategy.applyFunction(lottoGameView,
                view -> {
                    LottoBonusNumberCreateRequest lottoBonusNumberCreateRequest =
                            view.inputLottoBonusNumberCreateRequest();
                    return new LottoBonusNumber(lottoWinningNumber,
                            lottoBonusNumberCreateRequest.getBonusNumber());
                });
    }

    private LottoWinningNumber createLottoWinningNumber() {
        return (LottoWinningNumber) exceptionHandlingStrategy.applyFunction(lottoGameView,
                view -> {
                    LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest =
                            view.inputLottoWinningNumberCreateRequest();
                    return new LottoWinningNumber(lottoWinningNumberCreateRequest.getNumbers());
                });
    }


    private LottoPurchase purchaseLotto() {
        return (LottoPurchase) exceptionHandlingStrategy.applyFunction(lottoGameView,
                view -> {
                    LottoPurchaseRequest lottoPurchaseRequest = view.inputPurchaseRequest();
                    return new LottoPurchase(lottoPurchaseRequest.getPurchaseAmount());
                });
    }

}
