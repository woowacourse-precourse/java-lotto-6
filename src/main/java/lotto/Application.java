package lotto;

import lotto.validator.InputMoneyValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputMoneyValidator inputMoneyValidator = new InputMoneyValidator(InputView.inputMoney());
    }
}
