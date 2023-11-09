package lotto.controller;

import lotto.domain.User;
import lotto.domain.Winning;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchasePriceRequest;
import lotto.dto.request.WinningNumberRequest;
import lotto.dto.response.PurchasePriceResponse;
import lotto.dto.response.WinningResponse;
import lotto.exception.InputException;
import lotto.service.GameManagerService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameManagerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameManagerService gameManagerService;
    private final LottoService lottoService;

    public GameManagerController(final InputView inputView,
                                 final OutputView outputView,
                                 final GameManagerService gameManagerService,
                                 final LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameManagerService = gameManagerService;
        this.lottoService = lottoService;
    }

    public void start() {
        try {
            final User user = createUser();
            final Winning winning = createWinning();
            settle(user, winning);
        } catch (InputException e) {
            outputView.printExceptionMessage(e);
            start();
        }
    }

    private void settle(final User user, final Winning winning) {
        final WinningResponse winningResponse = gameManagerService.settleWinningResult(user, winning);
        outputView.printWinningStatistic(winningResponse);
    }

    private Winning createWinning() {
        final WinningNumberRequest winningNumberRequest = inputWinningNumber();
        final BonusNumberRequest bonusNumberRequest = inputBonusNumber();
        return lottoService.createWinning(winningNumberRequest, bonusNumberRequest);
    }

    private User createUser() {
        final PurchasePriceRequest purchasePriceRequest = inputPurchase();
        final User user = lottoService.createUser(purchasePriceRequest);
        outputView.printPurchaseLottos(PurchasePriceResponse.createResponsesFromUser(user));
        return user;
    }

    private PurchasePriceRequest inputPurchase() {
        outputView.printPurchasePriceQuestionMessage();
        return inputView.requestPurchasePrice();
    }

    private WinningNumberRequest inputWinningNumber() {
        outputView.printWinningNumberQuestionMessage();
        return inputView.requestWinningNumber();
    }

    private BonusNumberRequest inputBonusNumber() {
        outputView.printBonusNumberQuestionMessage();
        return inputView.requestBonusNumber();
    }
}
