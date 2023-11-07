package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import lotto.service.LottoService;
import lotto.view.InputView;
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
        PurchasePrice money = inputView.getMoney();
        List<PurchaseResult> purchaseResults = lottoService.purchaseLottos(money);
        LottoTickets lottoTickets = LottoTickets.create(purchaseResults);
        outputView.printPurchaseResult(purchaseResults);

        Lotto lotto = inputView.getWinningNumbers(); //TODO: 네이밍 수정 필요
        BonusNumber bonusNumber = inputView.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusNumber);

        LottoGameResult lottoGameResult = lottoService.calcRank(lottoTickets.getTickets(), winningNumbers);
        outputView.printLottoGameResult(lottoGameResult);
        YieldResult yieldResult = lottoService.calcYield(money, lottoGameResult);

        outputView.printYield(yieldResult);
    }

}
