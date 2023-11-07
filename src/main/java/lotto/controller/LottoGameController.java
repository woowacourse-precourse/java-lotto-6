package lotto.controller;

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
        String budgetInput = InputView.inputBudget();
        InputValidator.validateBudget(budgetInput);

        Integer budget = Integer.parseInt(budgetInput);

        /// TODO: 로또 생성 및 출력
        lottoGameService.buyLottosWithBudget(budget);
        OutputView.printPurchasedLottoCount(lottoGameService.getLottoCount());
        OutputView.printPurchasedLottos(lottoGameService.getLottos());

        /// TODO: 당첨 번호 입력
        /// TODO: 보너스 번호 입력
    }

}
