package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.domain.PurchasePrice;
import lotto.dto.PurchaseResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        PurchasePrice money = inputView.getMoney();
        int purchaseLottoAmount = money.getPurchaseLottoAmount();
        List<PurchaseResult> purchaseResults = lottoService.purchaseLottos(purchaseLottoAmount);
        LottoTickets lottoTickets = LottoTickets.create(purchaseResults);
        outputView.printPurchaseResult(purchaseResults);
        WinningNumbers winningNumbers = inputView.getWinningNumbers();
        BonusNumber bonusNumber = inputView.getBonusNumber();

    }

}
