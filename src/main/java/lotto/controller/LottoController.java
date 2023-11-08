package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;
    private WinningService winningService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController(){
        this.lottoService = new LottoService();
        this.winningService = new WinningService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playGame(){
        int purchaseAmount = inputView.getUserInputPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.printLottoPurchaseSummary(lottoTickets);

        List<Integer> winningNumbers = inputView.getUserInputWinningNumbers();
        int bonusNumber = inputView.getUserInputBonusNumber(winningNumbers);
        WinningLotto winningLotto = winningService.createWinningNumber(winningNumbers, bonusNumber);

        WinningResult winningResult = winningService.calculateResults(lottoTickets, winningLotto);
        outputView.printWinningResult(winningResult, lottoTickets);
    }
}
