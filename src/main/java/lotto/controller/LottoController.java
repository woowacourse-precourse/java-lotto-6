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
    LottoService lottoService;
    WinningService winningService;
    InputView inputView;
    OutputView outputView;

    public LottoController(){
        lottoService = new LottoService();
        winningService = new WinningService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playGame(){
        int purchaseAmount = inputView.getUserInputPurchaseAmount();
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.printLottoPurchaseSummary(lottoTickets);

        List<Integer> winningNumbers = inputView.getUserInputWinningNumbers();
        int bonusNumber = inputView.getUserInputBonusNumber();
        WinningLotto winningLotto = winningService.createWinningNumber(winningNumbers, bonusNumber);

        WinningResult winningResult = winningService.calculateResults(lottoTickets, winningLotto);
        outputView.printWinningResult(winningResult, lottoTickets);
    }
}
