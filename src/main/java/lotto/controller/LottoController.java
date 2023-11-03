package lotto.controller;

import lotto.domain.validator.Validator;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        int countOfLotto = buyLotto();
        System.out.println("countOfLotto : " + countOfLotto);
    }

    public int buyLotto() {
        boolean existInputFlag = false;
        boolean numericInputFlag = false;

        String inputValue = InputView.inputMoney();

        try {
            Validator.validateExistValue(inputValue);
            int inputMoney = Validator.validateNumericInput(inputValue);
            int countOfLotto = Validator.validateDivisibleBy1000(inputMoney);

            return countOfLotto;
        } catch (IllegalArgumentException e) {
            System.err.println(e);

            return this.buyLotto();
        }
    }
}
