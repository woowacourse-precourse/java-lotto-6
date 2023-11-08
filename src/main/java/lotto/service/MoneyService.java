package lotto.service;

import lotto.exception.Exception;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MoneyService {

    void check_null(Money money) {
        if (money == null) {
            Exception.raiseInvalidInputException();
        }
    }

    public Money requestValidLottoPurchaseAmount() {
        boolean isSuccess = false;
        Money money = null;
        while (!isSuccess) {
            try {
                OutputView.printMoneyInputRequestMessage();
                String cost = InputView.getMoneyForLottoPurchasing();
                money = new Money(cost);
                check_null(money);
                isSuccess = true;
            } catch (IllegalArgumentException moneyInputError) {
                OutputView.printErrorMessage(moneyInputError);
            }
        }
        return money;
    }
}
