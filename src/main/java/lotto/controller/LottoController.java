package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningTicket;
import lotto.domain.dto.Result;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.inputPurchaseAmount());
        LottoTickets lottoTickets = lottoService.purchase(purchaseAmount);
        outputView.printPurchasedLottos(lottoTickets.lottos());

        Lotto winningLotto = new Lotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());
        WinningTicket winningTicket = new WinningTicket(winningLotto, bonusNumber);

        Result winningResult = lottoService.getWinningResult(lottoTickets, winningTicket);
        outputView.printWinningResult(winningResult);
    }
}
