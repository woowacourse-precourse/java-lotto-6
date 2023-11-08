package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int purchaseAmount = inputView.inputMoney();
        List<LottoTicket> tickets = lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.printPurchasedTickets(tickets);

        List<Integer> winningNumbers = inputView.inputWinningNumber();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        LottoResult result = lottoService.checkLottoTickets(tickets, winningLotto);
        outputView.printWinningStatistics(result);

        double profitRate = result.calculateProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
