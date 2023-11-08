package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import lotto.service.LottoService;
import lotto.util.ExceptionHandler;
import lotto.view.InputViewProxy;
import lotto.view.OutputView;

import java.util.List;

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
        PurchasePrice money = getMoneyFromUser();
        List<PurchaseResult> purchaseResults = purchaseLottoTickets(money);
        outputView.printPurchaseResult(purchaseResults);

        WinningNumbers winningNumbers = getWinningNumbersFromUser();
        LottoGameResult lottoGameResult = calculateGameResult(purchaseResults, winningNumbers);
        outputView.printLottoGameResult(lottoGameResult);

        YieldResult yieldResult = calculateYield(money, lottoGameResult);
        outputView.printYield(yieldResult);
    }

    private PurchasePrice getMoneyFromUser() {
        return inputView.getMoney();
    }

    private List<PurchaseResult> purchaseLottoTickets(PurchasePrice money) {
        return lottoService.purchaseLottos(money);
    }

    private WinningNumbers getWinningNumbersFromUser() {
        Lotto lotto = inputView.getWinningNumbers();
        return ExceptionHandler.handle(() -> getWinningNumbers(lotto));
    }

    private WinningNumbers getWinningNumbers(Lotto lotto) {
        BonusNumber bonusNumber = inputView.getBonusNumber();
        return new WinningNumbers(lotto, bonusNumber);
    }

    private LottoGameResult calculateGameResult(List<PurchaseResult> purchaseResults, WinningNumbers winningNumbers) {
        LottoTickets lottoTickets = LottoTickets.create(purchaseResults);
        return lottoService.calcRank(lottoTickets.getTickets(), winningNumbers);
    }

    private YieldResult calculateYield(PurchasePrice money, LottoGameResult lottoGameResult) {
        return lottoService.calcYield(money, lottoGameResult);
    }
}
