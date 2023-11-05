package lotto.controller;

import java.util.List;
import lotto.application.LottoService;
import lotto.application.LottoStatistics;
import lotto.ui.InputHandler;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputHandler inputHandler;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputHandler = new InputHandler(inputView, outputView);

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
        validateBasicInput(purchaseAmountInput);
        int purchaseAmount = ParserUtil.parseLottoNumber(purchaseAmountInput);
        ValidationUtil.validateThousandUnit(purchaseAmount);
        return purchaseAmount;
    }

    private List<Integer> inputValidateWinningNumbers() {
        String winningNumbersInput = inputView.inputWinningNumbers();
        validateBasicInput(winningNumbersInput);
        List<Integer> winningNumbers = ParserUtil.parseWinningNumbers(winningNumbersInput);
        ValidationUtil.validateCorrectNumbersCount(winningNumbers);
        ValidationUtil.validateNoDuplicates(winningNumbers);
        ValidationUtil.validateNumberRange(winningNumbers);
        return winningNumbers;
    }

    private int inputValidateBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberInput = inputView.inputBonusNumber();
        validateBasicInput(bonusNumberInput);
        int bonusNumber = ParserUtil.parseLottoNumber(bonusNumberInput);
        ValidationUtil.validateBonusNumber(bonusNumber);
        ValidationUtil.validateBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private void validateBasicInput(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
    }
}
