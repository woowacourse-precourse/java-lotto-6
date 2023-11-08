package lotto.controller;

import lotto.Lotto;
import lotto.LottoGameService;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoGameService lottoGameService;

    public LottoGameController() {
        lottoGameService = new LottoGameService();
    }

    public void run() {
        /// 로또 구입 금액 입력
        String budgetInput = InputView.inputBudget();
        InputValidator.validateBudget(budgetInput);

        Integer budget = Integer.parseInt(budgetInput);

        /// 로또 생성 및 출력
        lottoGameService.buyLottosWithBudget(budget);
        OutputView.printPurchasedLottoCount(lottoGameService.getLottoCount());

        for (Lotto lotto : lottoGameService.getLottos()) {
            OutputView.printLotto(lotto.getNumbers());
        }

        /// 당첨 번호 입력
        String winningNumberInput = InputView.inputWinningNumbers();
        InputValidator.validateWinningNumber(winningNumberInput);
        lottoGameService.setWinningNumbers(winningNumberInput);

        /// 보너스 번호 입력
        String bonusNumberInput = InputView.inputBonusNumber();
        InputValidator.validateBonusNumber(bonusNumberInput, lottoGameService.getWinningNumbers());
        lottoGameService.setBonusNumber(bonusNumberInput);

        /// TODO Compare or MakeResult
    }

}
