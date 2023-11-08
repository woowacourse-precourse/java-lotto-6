package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import lotto.service.LottoService;
import lotto.util.ExceptionHandler;
import lotto.view.InputViewProxy;
import lotto.view.OutputView;

public class GameController {

    private final LottoService lottoService;
    private final InputViewProxy inputView;
    private final OutputView outputView;

    public GameController(LottoService lottoService, InputViewProxy inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        PurchaseCost money = getMoneyFromUser();
        // no - sex
        PurchaseResult purchaseResults = purchaseLottoTickets(money);
        outputView.printPurchaseResult(purchaseResults);

        WinningNumbers winningNumbers = getWinningNumbers();
        LottoGameResult lottoGameResult = calculateGameResult(purchaseResults, winningNumbers);
        outputView.printLottoGameResult(lottoGameResult);

        YieldResult yieldResult = calculateYield(money, lottoGameResult);
        outputView.printYield(yieldResult);
    }

    private PurchaseCost getMoneyFromUser() {
        return inputView.getMoney();
    }

    private PurchaseResult purchaseLottoTickets(PurchaseCost money) {
        return lottoService.purchaseLottos(money);
    }

    private WinningNumbers getWinningNumbers() {
        Lotto lotto = inputView.getWinningNumbers();
        return ExceptionHandler.handle(() -> getWinningNumbers(lotto));
    }

    private WinningNumbers getWinningNumbers(Lotto lotto) {
        BonusNumber bonusNumber = inputView.getBonusNumber();
        return new WinningNumbers(lotto, bonusNumber);
    }

    private LottoGameResult calculateGameResult(PurchaseResult purchaseResults, WinningNumbers winningNumbers) {
        LottoTickets lottoTickets = LottoTickets.create(purchaseResults);
        return lottoService.calcRank(lottoTickets.getTickets(), winningNumbers);
    }

    private YieldResult calculateYield(PurchaseCost money, LottoGameResult lottoGameResult) {
        return lottoService.calcYield(money, lottoGameResult);
    }
}
