package lotto.controller;

import java.util.List;

import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final LottoService lottoService, final InputView inputView, final OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        PurchaseAmount amount = askPurchaseAmount();
        Lottos lottos = buyLottos(amount);
        printLottos(lottos);
        WinningNumbers winningNumbers = askWinningNumbers();
        LottoStatistic statistic = createStatisticOf(amount, lottos, winningNumbers);
        printStatistic(statistic);
    }

    private PurchaseAmount askPurchaseAmount() {
        return lottoService.askPurchaseAmount(inputView::askPurchaseAmount);
    }

    private Lottos buyLottos(final PurchaseAmount amount) {
        return lottoService.buyLottos(amount);
    }

    private void printLottos(Lottos lottos) {
        outputView.printLottos(lottos);
    }

    private WinningNumbers askWinningNumbers() {
        List<Integer> numbers = lottoService.askWinningNumbers(inputView::askWinningNumbers);
        int bonusNumber = lottoService.askBonusNumber(inputView::askBonusNumber);
        return lottoService.createWinningNumbers(numbers, bonusNumber);
    }

    private LottoStatistic createStatisticOf(PurchaseAmount amount, Lottos lottos, WinningNumbers winningNumbers) {
        return lottoService.createStatisticOf(amount, lottos, winningNumbers);
    }

    private void printStatistic(LottoStatistic statistic) {
        outputView.printStatistic(statistic);
    }
}
