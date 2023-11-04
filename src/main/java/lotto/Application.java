package lotto;

import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);

        int amount = inputView.readLottoPurchaseMoney();
        Money money = new Money(amount);
    }
}
