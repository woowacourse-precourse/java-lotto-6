package lotto.controller;

import java.util.List;
import lotto.application.LottoService;
import lotto.application.LottoStatistics;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getValidatedInput(this::inputValidatePurchaseAmount);
        lottoService.purchaseLottoTickets(purchaseAmount);
        outputView.printLottos(lottoService.getLottoDtos());

        List<Integer> winningNumbers = getValidatedInput(this::inputValidateWinningNumbers);
        int bonusNumber = getValidatedInput(() -> inputValidateBonusNumber(winningNumbers));

        lottoService.processWinningNumbers(winningNumbers, bonusNumber);
        outputView.printPrizeResults(lottoService.getPrizeCount());

        LottoStatistics statistics = new LottoStatistics(lottoService.getLottoResult(), purchaseAmount);
        outputView.printEarningsRate(statistics.calculateEarningsRate());
    }

    private <T> T getValidatedInput(InputSupplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printError();
            }
        }
    }
    private void validateBasicInput(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
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
        ValidationUtil.validateBonusNumberNotInWinningNumbers(bonusNumber,winningNumbers);
        return bonusNumber;
    }

    @FunctionalInterface
    interface InputSupplier<T> {
        T get() throws IllegalArgumentException;
    }
}
