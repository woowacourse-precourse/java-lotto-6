package lotto.controller;

import java.util.List;
import lotto.application.LottoService;
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
        int purchaseAmountInput = ParserUtil.parseStringToInt(inputView.inputPurchaseAmount());
        validatePurchaseAmountInput(purchaseAmountInput);
        //구입처리
        lottoService.purchaseLottoTickets(purchaseAmountInput);
        outputView.printLottos(lottoService.getLottoDtos());
        // 사용자로부터 당첨 번호를 입력받고
        List<Integer> winningNumbersInput = ParserUtil.parseStringToIntList(inputView.inputWinningNumbers());
        validateWinningNumbers(winningNumbersInput);
        // 사용자로부터 보너스 번호를 입력받고
        int bonusNumberInput = ParserUtil.parseStringToInt(inputView.inputBonusNumber());
        validateBonusNumber(winningNumbersInput,bonusNumberInput);
        // 당첨 번호 처리하고
        lottoService.processWinningNumbers(winningNumbersInput, bonusNumberInput);
        // 결과 출력
    }
    //젓번째 입력 검증 메소드
    private void validatePurchaseAmountInput(int input) {
        ValidationUtil.validateNonNegative(input); // 음수인지
        ValidationUtil.validateThousandUnit(input); // 숫자인지 검사
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