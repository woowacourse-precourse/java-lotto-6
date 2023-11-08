package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.LottoPurchaseMoney;
import lotto.model.LottoWinningNumbers;
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
        LottoPurchaseMoney amount = askPurchaseMoney();
        Lottos lottos = buyLottos(amount);
        printLottos(lottos);
        LottoWinningNumbers lottoWinningNumbers = askWinningNumbers();
        LottoStatistic statistic = createStatisticOf(amount, lottos, lottoWinningNumbers);
        printStatistic(statistic);
    }

    private LottoPurchaseMoney askPurchaseMoney() {
        return lottoService.askPurchaseMoney(inputView::askPurchaseMoney);
    }

    private Lottos buyLottos(final LottoPurchaseMoney amount) {
        return lottoService.buyLottos(amount);
    }

    private void printLottos(final Lottos lottos) {
        outputView.printLottos(lottos);
    }

    private LottoWinningNumbers askWinningNumbers() {
        Lotto numbers = lottoService.askWinningNumbers(inputView::askWinningNumbers);
        return lottoService.createWinningNumbers(numbers, inputView::askBonusNumber);
    }

    private LottoStatistic createStatisticOf(
            final LottoPurchaseMoney amount,
            final Lottos lottos,
            final LottoWinningNumbers lottoWinningNumbers) {
        return lottoService.createStatistic(amount, lottos, lottoWinningNumbers);
    }

    private void printStatistic(final LottoStatistic statistic) {
        outputView.printStatistic(statistic);
    }
}
