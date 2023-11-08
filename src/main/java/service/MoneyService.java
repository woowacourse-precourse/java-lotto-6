package service;

import model.Money;
import view.InputView;
import view.OutputView;

public class MoneyService {

    public Money requestValidLottoPurchaseAmount() {
        boolean isSuccess = false;
        Money money = null;
        while (!isSuccess) {
            try {
                OutputView.printMoneyInputRequestMessage();
                String cost = InputView.getMoneyForLottoPurchasing();
                money = new Money(cost);
                isSuccess = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        return money;
    }
}
