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
        // 입력받고
        int purchaseAmountInput = ParserUtil.parseLottoNumber(inputView.inputPurchaseAmount());
        validatePurchaseAmountInput(purchaseAmountInput);
        //구입처리
        lottoService.purchaseLottoTickets(purchaseAmountInput);
        outputView.printLottos(lottoService.getLottoDtos());
        // 사용자로부터 당첨 번호를 입력받고
        List<Integer> winningNumbersInput = ParserUtil.parseWinningNumbers(inputView.inputWinningNumbers());
        validateWinningNumbers(winningNumbersInput);
        // 사용자로부터 보너스 번호를 입력받고
        int bonusNumberInput = ParserUtil.parseLottoNumber(inputView.inputBonusNumber());
        validateBonusNumber(winningNumbersInput, bonusNumberInput);
        // 당첨 번호 처리하고
        lottoService.processWinningNumbers(winningNumbersInput, bonusNumberInput);
        outputView.printPrizeResults(lottoService.getPrizeCount());
        // 통계 출력
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