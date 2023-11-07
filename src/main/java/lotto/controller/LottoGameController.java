package lotto.controller;

import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoGameController {

    public void run() {
        /// TODO: 로또 구입 금액 입력
        String budgetInput = InputView.inputBudget();
        InputValidator.validateBudget(budgetInput);

        Integer budget = Integer.parseInt(budgetInput);

        /// TODO: 로또 생성 및 출력
        /// TODO: 당첨 번호 입력
        /// TODO: 보너스 번호 입력
    }

}
