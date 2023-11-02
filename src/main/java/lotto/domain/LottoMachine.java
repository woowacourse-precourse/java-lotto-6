package lotto.domain;

import lotto.constant.NumberConstants;
import lotto.validation.InputValidator;
import lotto.view.InputView;

import static lotto.constant.NumberConstants.*;

public class LottoMachine {

    public int purchaseLotto() {
        while (true) {
            String input = InputView.PurchaseAmount();
            if (InputValidator.isNumeric(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public int calculateAmount(int amount) {

        if (InputValidator.isCalculate(amount)) {
            return amount / LOTTO_PRICE.getValue();
        }
        return -1;

    }



}
