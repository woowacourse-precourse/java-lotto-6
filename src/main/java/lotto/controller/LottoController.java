package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningStatistics;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run(){
        Integer purchaseAmount = inputPurchaseAmount();
        buyLotto(purchaseAmount);
        List<Prize> winPrizes = checkResult();
        viewStatistics(winPrizes, purchaseAmount);
    }

    private Integer inputPurchaseAmount() {
        Integer purchaseAmount = inputView.requestPurchaseAmountInput();
        return purchaseAmount;
    }

    private void buyLotto(Integer purchaseAmount) {
        List<Lotto> lottos = lottoService.buyLotto(purchaseAmount);
        outputView.responseLottos(lottos);
    }

    private List<Prize> checkResult() {
        List<Integer> winningNumbers = inputView.requestWinningNumbersInput();
        Integer bonusNumber = inputView.requestBonusNumberInput();
        List<Prize> winPrizes = lottoService.calculateTotalPrizes(winningNumbers, bonusNumber);
        return winPrizes;
    }

    private void viewStatistics(List<Prize> winPrizes, Integer purchaseAmount) {
        WinningStatistics winningStatistics = lottoService.generateStatistics(winPrizes);
        outputView.responseWinningStatistics(winningStatistics, purchaseAmount);
    }
}
