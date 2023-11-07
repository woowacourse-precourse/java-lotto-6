package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.WinningList;
import lotto.service.CalculationService;
import lotto.service.LottoValidator;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Lottos lottos;
    private final WinningList winningList;
    private final WinningService winningService;
    private final CalculationService calculationService;
    public LottoController(
            InputView inputView,
            OutputView outputView,
            Lottos lottos,
            WinningList winningList,
            WinningService winningService,
            CalculationService calculationService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winningList = winningList;
        this.lottos = lottos;
        this.winningService = winningService;
        this.calculationService = calculationService;
    }
    public void run() {
        final int LOTTO_COUNT = getBuyLottoCount();

        buyLotto(LOTTO_COUNT);
        outputView.printLottoNumbers(lottos);

        checkWinning();
        outputView.printWinningResult(winningList);

        printYield(LOTTO_COUNT);
    }

    public int getBuyLottoCount() {
        final LottoValidator lottoValidator = new LottoValidator();
        int buyAmount = inputView.getBuyAmount();
        while (!lottoValidator.isValidAmount(buyAmount)) {
            buyAmount = inputView.getBuyAmount();
        }
        return calculationService.getBuyLottoCount(buyAmount);
    }
    public void buyLotto(int buyLottoCount) {
        outputView.printBuyLottoCount(buyLottoCount);
        lottos.createLottos(buyLottoCount);
    }

    public int[] getValidWinningNumbers() {
        final LottoValidator lottoValidator = new LottoValidator();
        int[] winningNumbers = inputView.getWinningNumbers();
        while (!lottoValidator.isValidLottoNumbers(winningNumbers)) {
            winningNumbers = inputView.getWinningNumbers();
        }
        return winningNumbers;
    }

    public void checkWinning() {
        int[] winningNumbers = getValidWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

        int[] winningCounts = lottos.checkWinnings(winningNumbers, bonusNumber);
        winningService.plusWinningCounts(winningCounts);
    }

    public void printYield(int lottoCount) {
        int profit = calculationService.getProfit(winningList);
        Double yields = calculationService.getYields(lottoCount * 1000, profit);
        outputView.printYields(yields);
    }
}
