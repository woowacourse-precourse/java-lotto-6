package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoGameService;
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
        Integer budget;
        while (true) {
            try {
                String budgetInput = InputView.inputBudget();
                InputValidator.validateBudget(budgetInput);
                budget = Integer.parseInt(budgetInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        /// 로또 생성 및 출력
        List<Lotto> lottos = lottoGameService.buyLottosWithBudget(budget);
        OutputView.printPurchasedLottoCount(lottos.size());

        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto.getNumbers());
        }

        /// 당첨 번호 입력
        List<Integer> winningNumbers;
        while(true) {
            try {
                String winningNumberInput = InputView.inputWinningNumbers();
                InputValidator.validateWinningNumber(winningNumberInput);

                String[] numbers = winningNumberInput.split(",");
                winningNumbers = Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        /// 보너스 번호 입력
        Integer bonusNumber;
        while (true) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                InputValidator.validateBonusNumber(bonusNumberInput, winningNumbers);

                bonusNumber = Integer.parseInt(bonusNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        /// 결과 계산 및 출력
        LottoResult lottoResult = lottoGameService.calculateTotalResult(lottos, winningNumbers,
            bonusNumber);
        Double rateOfReturn = lottoGameService.calculateReturnRate(lottoResult.getTotalMoney(),
            budget);
        OutputView.printTotalResult(lottoResult, rateOfReturn);
    }

}
