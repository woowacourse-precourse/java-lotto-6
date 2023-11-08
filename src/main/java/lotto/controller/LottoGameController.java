package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.LottoGameService;
import lotto.model.LottoResult;
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
        List<Lotto> lottos = lottoGameService.buyLottosWithBudget(budget);
        OutputView.printPurchasedLottoCount(lottos.size());

        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto.getNumbers());
        }

        /// 당첨 번호 입력
        String winningNumberInput = InputView.inputWinningNumbers();
        InputValidator.validateWinningNumber(winningNumberInput);

        String[] numbers = winningNumberInput.split(",");
        List<Integer> winningNumbers = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .toList();

        /// 보너스 번호 입력
        String bonusNumberInput = InputView.inputBonusNumber();
        InputValidator.validateBonusNumber(bonusNumberInput, winningNumbers);

        Integer bonusNumber = Integer.parseInt(bonusNumberInput);

        /// 결과 계산 및 출력
        LottoResult lottoResult = lottoGameService.calculateTotalResult(lottos, winningNumbers,
            bonusNumber);
        Double rateOfReturn = lottoGameService.calculateReturnRate(lottoResult.getTotalMoney(),
            budget);
        OutputView.printTotalResult(lottoResult, rateOfReturn);
    }

}
