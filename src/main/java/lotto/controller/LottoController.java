package lotto.controller;

import static lotto.exception.ErrorMessage.ERROR;

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
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        Lottos lottos = lottoService.generateLottos(purchaseAmount);
        outputView.printPurchaseResult(lottos);
        WinningNumbers winningNumbers = askWinningNumbers();
        LottoStatistic statistic = lottoService.generateStatistic(lottos, winningNumbers);
        outputView.printStatistic(purchaseAmount, statistic);
    }

    private PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(askPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private int askPurchaseAmount() {
        while (true) {
            try {
                return inputView.askPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }

    }

    private WinningNumbers askWinningNumbers() {
        while (true) {
            try {
                List<Integer> numbers = inputView.askWinningNumbers();
                int bonusNumber = inputView.askBonusNumber();
                return WinningNumbers.of(numbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }
}
