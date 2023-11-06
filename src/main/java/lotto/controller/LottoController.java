package lotto.controller;

import java.util.List;
import lotto.application.LottoService;
import lotto.application.LottoStatistics;
import lotto.ui.InputHandler;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.domain.vo.BonusNumberVO;
import lotto.domain.vo.PurchaseAmountVO;
import lotto.domain.vo.WinningNumbersVO;

public class LottoController {
    private final LottoService lottoService;
    private final InputHandler inputHandler;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputHandler = new InputHandler(outputView);
    }

    public void run() {
        int purchaseAmount = inputHandler.getValidatedInput(this::inputValidatePurchaseAmount);
        purchaseLotto(purchaseAmount);

        List<Integer> winningNumbers = inputHandler.getValidatedInput(this::inputValidateWinningNumbers);
        int bonusNumber = inputHandler.getValidatedInput(() -> inputValidateBonusNumber(winningNumbers));
        processWinningNumbers(winningNumbers, bonusNumber);

        displayResults(purchaseAmount);
    }

    private void purchaseLotto(int purchaseAmount) {
        lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.printLottos(lottoService.getLottoDtos());
    }

    private void processWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        lottoService.processWinningNumbers(winningNumbers, bonusNumber);
        outputView.printPrizeResults(lottoService.getPrizeCount());
    }

    private void displayResults(int purchaseAmount) {
        LottoStatistics statistics = new LottoStatistics(lottoService.getLottoResult(), purchaseAmount);
        outputView.printEarningsRate(statistics.calculateEarningsRate());
    }

    private int inputValidatePurchaseAmount() {
        String purchaseAmountInput = inputView.inputPurchaseAmount();
        PurchaseAmountVO purchaseAmount = new PurchaseAmountVO(purchaseAmountInput);
        return purchaseAmount.getAmount();
    }

    private List<Integer> inputValidateWinningNumbers() {
        String winningNumbersInput = inputView.inputWinningNumbers();
        WinningNumbersVO winningNumbers = new WinningNumbersVO(winningNumbersInput);
        return winningNumbers.getNumbers();
    }

    private int inputValidateBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberInput = inputView.inputBonusNumber();
        BonusNumberVO bonusNumber = new BonusNumberVO(bonusNumberInput, winningNumbers);
        return bonusNumber.getNumber();
    }
}
