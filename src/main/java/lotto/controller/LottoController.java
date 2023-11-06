package lotto.controller;

import java.util.List;

import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(final LottoService lottoService, final InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void play() {
        PurchaseAmount purchaseAmount = askPurchaseAmount();
        Lottos lottos = lottoService.generateLottos(purchaseAmount);
        WinningNumbers winningNumbers = askWinningNumbers();
        LottoStatistic statistic = lottoService.generateStatistic(lottos, winningNumbers);
    }

    private PurchaseAmount askPurchaseAmount() {
        return PurchaseAmount.from(inputView.askPurchaseAmount());
    }

    private WinningNumbers askWinningNumbers() {
        List<Integer> numbers = inputView.askWinningNumbers();
        int bonusNumber = inputView.askBonusNumber();
        return WinningNumbers.of(numbers, bonusNumber);
    }
}
