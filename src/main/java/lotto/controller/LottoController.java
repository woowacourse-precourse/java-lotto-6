package lotto.controller;

import lotto.model.Lotto;
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

    private void printLottos(final Lottos lottos) {
        outputView.printLottos(lottos);
    }

    private WinningNumbers askWinningNumbers() {
        Lotto numbers = lottoService.askWinningNumbers(inputView::askWinningNumbers);
        return lottoService.createWinningNumbers(numbers, inputView::askBonusNumber);
    }

    private LottoStatistic createStatisticOf(
            final PurchaseAmount amount,
            final Lottos lottos,
            final WinningNumbers winningNumbers) {
        return lottoService.createStatisticOf(amount, lottos, winningNumbers);
    }

    private void printStatistic(final LottoStatistic statistic) {
        outputView.printStatistic(statistic);
    }
}
