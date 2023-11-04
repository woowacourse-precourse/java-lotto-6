package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
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

        int purchaseAmountInput = ParserUtil.parseLottoNumber(inputView.inputPurchaseAmount());
        validatePurchaseAmountInput(purchaseAmountInput);

        lottoService.purchaseLottoTickets(purchaseAmountInput);
        outputView.printLottos(lottoService.getLottoDtos());

        List<Integer> winningNumbersInput = ParserUtil.parseWinningNumbers(inputView.inputWinningNumbers());
        validateWinningNumbers(winningNumbersInput);

        int bonusNumberInput = ParserUtil.parseLottoNumber(inputView.inputBonusNumber());
        validateBonusNumber(winningNumbersInput, bonusNumberInput);

        lottoService.processWinningNumbers(winningNumbersInput, bonusNumberInput);
        outputView.printPrizeResults(lottoService.getPrizeCount());

        LottoStatistics statistics = new LottoStatistics(lottoService.getLottoResult(), purchaseAmountInput);
        outputView.printEarningsRate(statistics.calculateEarningsRate());

        Console.close();

    }

    private void validatePurchaseAmountInput(int input) {
        ValidationUtil.validateNonNegative(input);
        ValidationUtil.validateThousandUnit(input);
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        ValidationUtil.validateCorrectNumbersCount(winningNumbers);
        ValidationUtil.validateNoDuplicates(winningNumbers);
        ValidationUtil.validateNumberRange(winningNumbers);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        ValidationUtil.validateBonusNumber(bonusNumber);
        ValidationUtil.validateBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers);
    }
}