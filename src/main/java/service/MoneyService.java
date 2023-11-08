package service;

import exception.Exception;
import model.Money;
import view.InputView;
import view.OutputView;

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
